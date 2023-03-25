package dio.desafio.academia.spring.jpa.expanded.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.desafio.academia.spring.jpa.expanded.dto.AlunoCompletoDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AlunoEnderecoMatriculaDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.services.AlunoService;

// Rest Controller (API)
@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<Page<AlunoTelefoneDTO>> findAll(@RequestParam(value = "bairroId", defaultValue = "") String bairroId,
														  @RequestParam(value = "tsInicio", defaultValue = "01-01-1800") String tsInicio,
														  @RequestParam(value = "tsFim", defaultValue = "01-01-2200") String tsFim,
														  Pageable pageable	) {
	     // http request direction is String, Direction is an enumeration type (so the need of valueOf)
 		
		Page<AlunoTelefoneDTO> list = alunoService.findAll( bairroId.trim(),tsInicio, tsFim, pageable);
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoCompletoDTO> findById(@PathVariable Long id) {
		AlunoCompletoDTO alunoDTO = alunoService.findById(id);
		return ResponseEntity.ok().body(alunoDTO);

	}
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AlunoEnderecoMatriculaDTO> delete(@PathVariable Long id){
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@PostMapping
	public ResponseEntity<AlunoEnderecoMatriculaDTO> insert( @RequestBody AlunoEnderecoMatriculaDTO alunoLongoDTO) {
		alunoLongoDTO = alunoService.insert(alunoLongoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(alunoLongoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(alunoLongoDTO);
		
	}
 
 
}
