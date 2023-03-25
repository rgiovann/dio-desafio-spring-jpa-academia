package dio.desafio.academia.spring.jpa.expanded.dto;

import java.io.Serializable;

import dio.desafio.spring.jpa.refatorado.enumerator.TipoTelefone;
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
public class TelefoneDTO implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@EqualsAndHashCode.Exclude
	private String nrTelefone;
	@EqualsAndHashCode.Exclude
	private TipoTelefone tipoTelefone;

}
