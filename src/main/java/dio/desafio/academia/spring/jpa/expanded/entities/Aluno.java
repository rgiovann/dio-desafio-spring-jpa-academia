package dio.desafio.academia.spring.jpa.expanded.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "tb_aluno" )
 
public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;

	@Column(unique = true )
 	private String cpf;
	
	@Column(name = "data_nascimento",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE" )
	
	private Instant dataNascimento; // instruct db to save data as ISO 8601 format (UTC)

	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
 	private Endereco endereco;
	
	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
 	private Matricula matricula;
	
	
	@OneToMany(mappedBy = "aluno", orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Telefone> telefones = new HashSet<Telefone>();

	@OneToMany(mappedBy = "aluno", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	private Set<AvaliacaoFisica> avaliacoesFisicas = new HashSet<AvaliacaoFisica>();

	public Aluno(Long id, String nome, String email, String cpf, Instant dataNascimento, Endereco endereco,
			Matricula matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}

	public void setAvaliacoesFisicas(Set<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
