package dio.desafio.academia.spring.jpa.expanded.services;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dio.desafio.academia.spring.jpa.expanded.config.Utilities;
import dio.desafio.academia.spring.jpa.expanded.dto.MatriculaAlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.MatriculaDTO;
import dio.desafio.academia.spring.jpa.expanded.entities.Matricula;
import dio.desafio.academia.spring.jpa.expanded.repositories.MatriculaRepository;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.ResourceNotFoundException;
import dio.desafio.spring.jpa.refatorado.enumerator.SituacaoDaMatricula;
import dio.desafio.spring.jpa.refatorado.enumerator.TipoDePagamento;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public MatriculaDTO findById(Long id) {
		Matricula entityMatricula = matriculaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		MatriculaDTO matriculaDTO = modelMapper.map(entityMatricula, MatriculaDTO.class);
		return matriculaDTO;
	}

	@Transactional
	public MatriculaDTO update(Long id, MatriculaDTO matriculaDTO) {

		Matricula entityMatricula = matriculaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull()); // (B)
		modelMapper.map(matriculaDTO, entityMatricula);
		modelMapper.map(entityMatricula, matriculaDTO);

		return matriculaDTO;

	}

	@Transactional(readOnly = true)
	public Page<MatriculaAlunoTelefoneDTO> findAll(String tipoPagamento, String situacaoMatricula, String tsInicio,
			String tsFim, Pageable pageRequest) {

		int inTipoPagamento = Integer.parseInt(tipoPagamento);
		int intSituacaoMatricula = Integer.parseInt(situacaoMatricula);
		if (intSituacaoMatricula + inTipoPagamento <= -2)   // os dois parametros vao ser inexistentes somente se a soma de -2 
		{
			Page<Matricula> list = matriculaRepository.findPorFiltro(
					Utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
					Utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
			return list.map(p -> modelMapper.map(p, MatriculaAlunoTelefoneDTO.class));
		} else if(intSituacaoMatricula <0) {
			Page<Matricula> list = matriculaRepository.findPorFiltro(
					TipoDePagamento.valueOf(Integer.parseInt(tipoPagamento)),
					Utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
					Utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
			return list.map(p -> modelMapper.map(p, MatriculaAlunoTelefoneDTO.class));		
		} else if(inTipoPagamento <0) {
			Page<Matricula> list = matriculaRepository.findPorFiltro(
					SituacaoDaMatricula.valueOf(Integer.parseInt(situacaoMatricula)),
					Utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
					Utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
			return list.map(p -> modelMapper.map(p, MatriculaAlunoTelefoneDTO.class));					
		}
		else {Page<Matricula> list = matriculaRepository.findPorFiltro(
				TipoDePagamento.valueOf(Integer.parseInt(tipoPagamento)),
				SituacaoDaMatricula.valueOf(Integer.parseInt(situacaoMatricula)),
				Utilities.converteParaInstant(tsInicio, "T00:00:00Z"),
				Utilities.converteParaInstant(tsFim, "T00:23:59Z"), pageRequest);
		return list.map(p -> modelMapper.map(p, MatriculaAlunoTelefoneDTO.class));
			
			
		}
	}
	 

}
