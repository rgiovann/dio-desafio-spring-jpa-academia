package dio.desafio.academia.spring.jpa.expanded.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@EqualsAndHashCode.Exclude
	private String nrTelefone;
	
	@EqualsAndHashCode.Exclude
	private TipoTelefone tipoTelefone;
	
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
		
}
