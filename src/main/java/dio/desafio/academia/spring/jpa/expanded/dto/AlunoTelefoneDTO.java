package dio.desafio.academia.spring.jpa.expanded.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
public class AlunoTelefoneDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@EqualsAndHashCode.Exclude
	private String nome;
	@EqualsAndHashCode.Exclude	
	private String email;
	@EqualsAndHashCode.Exclude
	private String cpf;
	@EqualsAndHashCode.Exclude
	private Instant dataNascimento; // instruct db to save data as ISO 8601 format (UTC)
	@EqualsAndHashCode.Exclude
	private Set<TelefoneDTO> telefones = new HashSet<TelefoneDTO>();


}
