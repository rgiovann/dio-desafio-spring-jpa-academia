package dio.desafio.academia.spring.jpa.expanded.dto;

import java.io.Serializable;
import java.time.Instant;

import dio.desafio.spring.jpa.refatorado.enumerator.SituacaoDaMatricula;
import dio.desafio.spring.jpa.refatorado.enumerator.TipoDePagamento;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaAlunoTelefoneDTO implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@EqualsAndHashCode.Exclude
	private SituacaoDaMatricula situacaoMatricula;
	@EqualsAndHashCode.Exclude
	private TipoDePagamento tipoPagamento;
	@EqualsAndHashCode.Exclude
 	private Instant dataMatricula; // ISO 8601 format (UTC)
	@EqualsAndHashCode.Exclude
 	private AlunoTelefoneDTO aluno;  

}
