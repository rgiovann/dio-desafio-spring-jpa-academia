package dio.desafio.academia.spring.jpa.expanded.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dio.desafio.spring.jpa.refatorado.enumerator.SituacaoDaMatricula;
import dio.desafio.spring.jpa.refatorado.enumerator.TipoDePagamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matricula",uniqueConstraints = { @UniqueConstraint(columnNames = { "aluno_id"}) })
public class Matricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(Matricula.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@EqualsAndHashCode.Exclude
	@Enumerated(EnumType.ORDINAL)
	private SituacaoDaMatricula situacaoMatricula;
	
	@EqualsAndHashCode.Exclude
	@Enumerated(EnumType.ORDINAL)
	private TipoDePagamento tipoPagamento;
	
	@EqualsAndHashCode.Exclude
	@Setter(AccessLevel.NONE)
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@EqualsAndHashCode.Exclude
	@Setter(AccessLevel.NONE)
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	@OneToOne
	@MapsId
    @JoinColumn(name = "aluno_id")
 	@NonNull
	private Aluno aluno;
	
	@EqualsAndHashCode.Exclude
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE",nullable=false)
 	private Instant dataMatricula; // ISO 8601 format (UTC)
		
	
 	@javax.persistence.PrePersist
 	public void PrePersist() {
 		this.createdAt = Instant.now();
		logger.info("Matricula aluno criada. ");

 	}
 	
 	@javax.persistence.PreUpdate
 	public void PreUpdate() {
 		this.updatedAt = Instant.now();		
		logger.info("Matricula aluno atualizada. ");
 	}

 
	
}
