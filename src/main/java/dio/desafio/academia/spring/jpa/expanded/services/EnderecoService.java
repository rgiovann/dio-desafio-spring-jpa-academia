package dio.desafio.academia.spring.jpa.expanded.services;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dio.desafio.academia.spring.jpa.expanded.dto.EnderecoDTO;
import dio.desafio.academia.spring.jpa.expanded.entities.Endereco;
import dio.desafio.academia.spring.jpa.expanded.repositories.EnderecoRepository;
import dio.desafio.academia.spring.jpa.expanded.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	public EnderecoDTO findById(Long id) {
		Endereco entity = enderecoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		EnderecoDTO enderecoDTO = modelMapper.map(entity, EnderecoDTO.class);
		return enderecoDTO;
	}

	@Transactional
	public EnderecoDTO update(Long id, EnderecoDTO enderecoDTO) {

		Endereco entityEndereco = enderecoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Error. Id not found: " + id));
		
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(enderecoDTO, entityEndereco);
		modelMapper.map(entityEndereco, enderecoDTO);
		return enderecoDTO;
	}

}
