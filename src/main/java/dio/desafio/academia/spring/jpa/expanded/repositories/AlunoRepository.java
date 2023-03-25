package dio.desafio.academia.spring.jpa.expanded.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dio.desafio.academia.spring.jpa.expanded.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Page<Aluno> findAllBy(Pageable pageRequest);

	@Query("SELECT obj FROM Aluno obj " + "WHERE  (LOWER(obj.endereco.bairro) LIKE LOWER(CONCAT('%',:bairroId,'%' ))) "
			+ "AND ( obj.dataNascimento >= :tsInicio AND obj.dataNascimento <= :tsFim )")
	Page<Aluno> findPorFiltro(String bairroId, Instant tsInicio, Instant tsFim, Pageable page);

}
