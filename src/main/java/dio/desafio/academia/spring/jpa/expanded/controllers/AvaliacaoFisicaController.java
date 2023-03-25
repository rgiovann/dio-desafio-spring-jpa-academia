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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.desafio.academia.spring.jpa.expanded.dto.AvaliacaoFisicaAlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.AvaliacaoFisicaDTO;
import dio.desafio.academia.spring.jpa.expanded.services.AvaliacaoFisicaService;

// Rest Controller (API)
@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	AvaliacaoFisicaService avaliacaoFisicaService;

	@PutMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> update( @PathVariable Long id, @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO){
		avaliacaoFisicaDTO = avaliacaoFisicaService.update(id, avaliacaoFisicaDTO);
		return ResponseEntity.ok().body(avaliacaoFisicaDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> findById(@PathVariable Long id) {
		AvaliacaoFisicaDTO avaliacaoFisicaDTO = avaliacaoFisicaService.findById(id);
		return ResponseEntity.ok().body(avaliacaoFisicaDTO);

	}
	
	
	@PostMapping(value = "/aluno/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> insert( @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO, @PathVariable Long id) {
		avaliacaoFisicaDTO = avaliacaoFisicaService.insert(avaliacaoFisicaDTO,id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(avaliacaoFisicaDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(avaliacaoFisicaDTO);
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> delete(@PathVariable Long id){
		avaliacaoFisicaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<Page<AvaliacaoFisicaAlunoTelefoneDTO>> findAll(@RequestParam(value = "objetivoAluno",defaultValue = "-1") String objetivoAluno,
														  @RequestParam(value = "tsInicio", defaultValue = "01-01-1800") String tsInicio,
														  @RequestParam(value = "tsFim", defaultValue = "01-01-2200") String tsFim,
														  Pageable pageable

			
			) {
	     // http request direction is String, Direction is an enumeration type (so the need of valueOf)
 		
		Page<AvaliacaoFisicaAlunoTelefoneDTO> list = avaliacaoFisicaService.findAll( objetivoAluno,tsInicio, tsFim, pageable);
		return ResponseEntity.ok().body(list);

	}
	
	 
}
