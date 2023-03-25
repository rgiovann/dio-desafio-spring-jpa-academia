package dio.desafio.academia.spring.jpa.expanded.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dio.desafio.spring.jpa.refatorado.enumerator.EstadoDoBrasil;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_endereco",uniqueConstraints = { @UniqueConstraint(columnNames = { "aluno_id"}) })
public class Endereco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @ JsonIgnore avoid loop Aluno-Endereco-Aluno....
 	@EqualsAndHashCode.Exclude
	@JsonIgnore
	@OneToOne
	@MapsId
    @JoinColumn(name = "aluno_id")

 	@NonNull
	private Aluno aluno;
	
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
