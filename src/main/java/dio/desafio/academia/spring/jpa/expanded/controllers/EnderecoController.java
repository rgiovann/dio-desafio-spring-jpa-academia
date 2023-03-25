package dio.desafio.academia.spring.jpa.expanded.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.desafio.academia.spring.jpa.expanded.dto.EnderecoDTO;
import dio.desafio.academia.spring.jpa.expanded.services.EnderecoService;

// Rest Controller (API)
@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;

	@PutMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> update( @PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO){
		enderecoDTO = enderecoService.update(id, enderecoDTO);
		return ResponseEntity.ok().body(enderecoDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
		EnderecoDTO enderecoDTO = enderecoService.findById(id);
		return ResponseEntity.ok().body(enderecoDTO);

	}
	 
}
