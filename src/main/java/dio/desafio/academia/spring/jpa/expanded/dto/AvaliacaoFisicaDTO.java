package dio.desafio.academia.spring.jpa.expanded.dto;

import java.io.Serializable;
import java.time.Instant;

import dio.desafio.spring.jpa.refatorado.enumerator.ObjetivoDoAluno;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 
public class AvaliacaoFisicaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

 	private Instant dataAvaliacao; // ISO 8601 format (UTC)

	@EqualsAndHashCode.Exclude
 	private Double peso;

	@EqualsAndHashCode.Exclude
 	private Double altura;
	
	@EqualsAndHashCode.Exclude
 	private ObjetivoDoAluno objetivoAluno;

}