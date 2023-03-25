package dio.desafio.academia.spring.jpa.expanded.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dio.desafio.academia.spring.jpa.expanded.entities.Matricula;
import dio.desafio.spring.jpa.refatorado.enumerator.SituacaoDaMatricula;
import dio.desafio.spring.jpa.refatorado.enumerator.TipoDePagamento;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	@Query("SELECT obj FROM Matricula obj INNER JOIN obj.aluno alu  WHERE  (obj.tipoPagamento=:tipoPagamento) "
			+ "AND (obj.situacaoMatricula=:situacaoMatricula) "
			+ "AND ( obj.dataMatricula >= :tsInicio AND obj.dataMatricula <= :tsFim )")
	Page<Matricula> findPorFiltro(TipoDePagamento tipoPagamento, SituacaoDaMatricula situacaoMatricula,
			Instant tsInicio, Instant tsFim, Pageable page);

	@Query("SELECT obj FROM Matricula obj INNER JOIN obj.aluno alu WHERE (obj.situacaoMatricula=:situacaoMatricula) "
			+ "AND ( obj.dataMatricula >= :tsInicio AND obj.dataMatricula <= :tsFim )")
	Page<Matricula> findPorFiltro(SituacaoDaMatricula situacaoMatricula, Instant tsInicio, Instant tsFim,
			Pageable page);
	
	@Query("SELECT obj FROM Matricula obj INNER JOIN obj.aluno alu  WHERE  (obj.tipoPagamento=:tipoPagamento) "
			+ "AND ( obj.dataMatricula >= :tsInicio AND obj.dataMatricula <= :tsFim )")
	Page<Matricula> findPorFiltro(TipoDePagamento tipoPagamento,Instant tsInicio, Instant tsFim, Pageable page);
	
	@Query("SELECT obj FROM Matricula obj INNER JOIN obj.aluno alu  WHERE ( obj.dataMatricula >= :tsInicio AND obj.dataMatricula <= :tsFim )")
	Page<Matricula> findPorFiltro(Instant tsInicio, Instant tsFim, Pageable page);

}
