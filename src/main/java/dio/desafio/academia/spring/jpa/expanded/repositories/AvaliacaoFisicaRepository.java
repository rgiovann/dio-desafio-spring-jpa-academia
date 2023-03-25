package dio.desafio.academia.spring.jpa.expanded.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dio.desafio.academia.spring.jpa.expanded.entities.AvaliacaoFisica;
import dio.desafio.spring.jpa.refatorado.enumerator.ObjetivoDoAluno;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

	@Query("SELECT obj FROM AvaliacaoFisica obj INNER JOIN obj.aluno alu  WHERE  (obj.objetivoAluno=:objetivoAluno) "
			+ "AND ( obj.dataAvaliacao >= :tsInicio AND obj.dataAvaliacao <= :tsFim )")
	Page<AvaliacaoFisica> findPorFiltro(ObjetivoDoAluno objetivoAluno, Instant tsInicio, Instant tsFim, Pageable page);
	
	@Query("SELECT obj FROM AvaliacaoFisica obj INNER JOIN obj.aluno alu  WHERE ( obj.dataAvaliacao >= :tsInicio AND obj.dataAvaliacao <= :tsFim )")
	Page<AvaliacaoFisica> findPorFiltro(Instant tsInicio, Instant tsFim, Pageable page);

}
