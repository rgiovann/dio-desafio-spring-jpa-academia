package dio.desafio.academia.spring.jpa.expanded.services;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dio.desafio.academia.spring.jpa.expanded.config.Utilities;
import dio.desafio.academia.spring.jpa.expanded.dto.AvaliacaoFisicaAlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AvaliacaoFisicaDTO;
import dio.desafio.academia.spring.jpa.expanded.entities.Aluno;
import dio.desafio.academia.spring.jpa.expanded.entities.AvaliacaoFisica;
import dio.desafio.academia.spring.jpa.expanded.repositories.AlunoRepository;
import dio.desafio.academia.spring.jpa.expanded.repositories.AvaliacaoFisicaRepository;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.DatabaseException;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.ResourceNotFoundException;
import dio.desafio.spring.jpa.refatorado.enumerator.ObjetivoDoAluno;

@Service
public class AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository  avaliacaoFisicaRepository;
	
	@Autowired
	AlunoRepository alunoRepository  ;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private Utilities utilities;
	
	
	@Transactional
	public AvaliacaoFisicaDTO insert(AvaliacaoFisicaDTO avaliacaoFisicaDTO, Long id) {
		
				Aluno entityAluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		
		
		AvaliacaoFisica entityAvaliacaoFisica = modelMapper.map(avaliacaoFisicaDTO, AvaliacaoFisica.class);
		
		entityAvaliacaoFisica.setAluno(entityAluno);
		
		entityAvaliacaoFisica = avaliacaoFisicaRepository.save(entityAvaliacaoFisica);
		
		return modelMapper.map(entityAvaliacaoFisica, AvaliacaoFisicaDTO.class);
	}


	@Transactional(readOnly = true)
	public AvaliacaoFisicaDTO findById(Long id) {
		AvaliacaoFisica entityMatricula = avaliacaoFisicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		AvaliacaoFisicaDTO avaliacaoFisicaDTO = modelMapper.map(entityMatricula, AvaliacaoFisicaDTO.class);
		return avaliacaoFisicaDTO;
	}

	@Transactional
	public AvaliacaoFisicaDTO update(Long id, AvaliacaoFisicaDTO avaliacaoFisicaDTO) {

		AvaliacaoFisica entityMatricula = avaliacaoFisicaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull()); // (B)
		modelMapper.map(avaliacaoFisicaDTO, entityMatricula);
		modelMapper.map(entityMatricula, avaliacaoFisicaDTO);

		return avaliacaoFisicaDTO;

	}
	
	
	@Transactional
	// rollback if something goes wrong
	public void delete(Long id) {
		try {
			avaliacaoFisicaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error. Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Error. Integrity violation: " + id);
		} catch (RuntimeException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
	

	@Transactional(readOnly = true)
	public Page<AvaliacaoFisicaAlunoTelefoneDTO> findAll(String objetivoAluno, String tsInicio,
			String tsFim, Pageable pageRequest) {

		int intObjetivoAluno = Integer.parseInt(objetivoAluno);
 
		if (intObjetivoAluno  <= -1)   // os dois parametros vao ser inexistentes somente se a soma de -2 
		{
			Page<AvaliacaoFisica> list = avaliacaoFisicaRepository.findPorFiltro(
					utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
					utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
			return list.map(p -> modelMapper.map(p, AvaliacaoFisicaAlunoTelefoneDTO.class));
		} 
		else {Page<AvaliacaoFisica> list = avaliacaoFisicaRepository.findPorFiltro(
				ObjetivoDoAluno.valueOf(intObjetivoAluno),
				utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
				utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
		return list.map(p -> modelMapper.map(p, AvaliacaoFisicaAlunoTelefoneDTO.class));
			
			
		}
	}
	 

}
