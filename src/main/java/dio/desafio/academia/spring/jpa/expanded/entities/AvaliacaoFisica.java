package dio.desafio.academia.spring.jpa.expanded.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "tb_avaliacao")
public class AvaliacaoFisica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@Column(name = "data_avaliacao",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataAvaliacao; // ISO 8601 format (UTC)

	@EqualsAndHashCode.Exclude
	@Column(name = "peso_atual")
	private Double peso;

	@EqualsAndHashCode.Exclude
	@Column(name = "altura_atual")
	private Double altura;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "objetivo_aluno")
	private ObjetivoDoAluno objetivoAluno;

}