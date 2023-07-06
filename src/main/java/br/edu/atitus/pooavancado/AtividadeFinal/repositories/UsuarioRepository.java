package br.edu.atitus.pooavancado.AtividadeFinal.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{
	
	@Query(value = "update Usuario set status = not status where id = :ident", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatusById(@Param("ident") long id);
	
	Optional<Usuario> findByEmail(String email);
	
	Page<Usuario> findByNomeContainingIgnoreCase(Pageable pageable, String nome);

	boolean existsByNomeAndIdNot(String nome, long id);
}
