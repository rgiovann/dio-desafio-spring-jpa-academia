package dio.desafio.academia.spring.jpa.expanded.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dio.desafio.academia.spring.jpa.expanded.dto.MatriculaAlunoTelefoneDTO;
import dio.desafio.academia.spring.jpa.expanded.dto.MatriculaDTO;
import dio.desafio.academia.spring.jpa.expanded.services.MatriculaService;

// Rest Controller (API)
@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaController {
	
	@Autowired
	MatriculaService matriculaService;

	@PutMapping(value = "/{id}")
	public ResponseEntity<MatriculaDTO> update( @PathVariable Long id, @RequestBody MatriculaDTO matriculaDTO){
		matriculaDTO = matriculaService.update(id, matriculaDTO);
		return ResponseEntity.ok().body(matriculaDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id) {
		MatriculaDTO matriculaDTO = matriculaService.findById(id);
		return ResponseEntity.ok().body(matriculaDTO);

	}
	
	@GetMapping
	public ResponseEntity<Page<MatriculaAlunoTelefoneDTO>> findAll(@RequestParam(value = "situacaoMatricula",defaultValue = "-1") String situacaoMatricula,
														  @RequestParam(value = "tipoPagamento",defaultValue = "-1") String tipoPagamento,
														  @RequestParam(value = "tsInicio", defaultValue = "01-01-1800") String tsInicio,
														  @RequestParam(value = "tsFim", defaultValue = "01-01-2200") String tsFim,
														  Pageable pageable

			
			) {
	     // http request direction is String, Direction is an enumeration type (so the need of valueOf)
 		
		Page<MatriculaAlunoTelefoneDTO> list = matriculaService.findAll( tipoPagamento,situacaoMatricula,tsInicio, tsFim, pageable);
		return ResponseEntity.ok().body(list);

	}
	
	
 
}
