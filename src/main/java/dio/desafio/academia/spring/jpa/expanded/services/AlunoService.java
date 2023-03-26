package dio.desafio.academia.spring.jpa.expanded.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dio.desafio.academia.spring.jpa.expanded.config.Utilities;
import dio.desafio.academia.spring.jpa.expanded.dto.AlunoCompletoDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AlunoEnderecoMatriculaDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.entities.Aluno;
import dio.desafio.academia.spring.jpa.expanded.entities.Endereco;
import dio.desafio.academia.spring.jpa.expanded.entities.Matricula;
import dio.desafio.academia.spring.jpa.expanded.repositories.AlunoRepository;
import dio.desafio.academia.spring.jpa.expanded.repositories.EnderecoRepository;
import dio.desafio.academia.spring.jpa.expanded.repositories.MatriculaRepository;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.DatabaseException;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private Utilities utilities;

	@Transactional(readOnly = true)
	public Page<AlunoTelefoneDTO> findAll(String bairroId, String tsInicio, String tsFim, Pageable pageRequest) {

		Page<Aluno> list = alunoRepository.findPorFiltro(bairroId, utilities.converteParaInstant(tsInicio, "T00:00:00Z"), 
				utilities.converteParaInstant(tsFim, "T00:00:00Z"),pageRequest);

		return list.map(p -> modelMapper.map(p, AlunoTelefoneDTO.class));

	}

	@Transactional(readOnly = true)
	public AlunoCompletoDTO findById(Long id) {
		Aluno entity = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		AlunoCompletoDTO productDTO = modelMapper.map(entity, AlunoCompletoDTO.class);
		return productDTO;
	}

	@Transactional
	public AlunoEnderecoMatriculaDTO insert(AlunoEnderecoMatriculaDTO alunoLongoDTO) {
		Aluno entityAluno = new Aluno();
		entityAluno = modelMapper.map(alunoLongoDTO, Aluno.class);

		Endereco entityEndereco = entityAluno.getEndereco();
		Matricula entityMatricula = entityAluno.getMatricula();

		entityMatricula.setAluno(entityAluno);
		entityEndereco.setAluno(entityAluno);

		entityMatricula = matriculaRepository.save(entityMatricula);
		entityEndereco = enderecoRepository.save(entityEndereco);
		
		Long id = enderecoRepository.findById(entityEndereco.getId()).get().getId();
		
		entityAluno = alunoRepository.findById(id).get();
		entityAluno.setMatricula(matriculaRepository.findById(id).get());
		entityAluno.setEndereco(enderecoRepository.findById(id).get());

		return modelMapper.map(entityAluno, AlunoEnderecoMatriculaDTO.class);
	}

	@Transactional
	// rollback if something goes wrong
	public void delete(Long id) {
		try {
			alunoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error. Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Error. Integrity violation: " + id);
		} catch (RuntimeException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
}
