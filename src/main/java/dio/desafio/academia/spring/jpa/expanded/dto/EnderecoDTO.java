package dio.desafio.academia.spring.jpa.expanded.dto;

import java.io.Serializable;

import dio.desafio.spring.jpa.refatorado.enumerator.EstadoDoBrasil;
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
public class EnderecoDTO implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

  	private Long id;
	@EqualsAndHashCode.Exclude
	private String endereco;
	@EqualsAndHashCode.Exclude
	private String bairro;
	@EqualsAndHashCode.Exclude
	private String cep;
	@EqualsAndHashCode.Exclude
	private String cidade;
	@EqualsAndHashCode.Exclude
 	private EstadoDoBrasil estado;

}
