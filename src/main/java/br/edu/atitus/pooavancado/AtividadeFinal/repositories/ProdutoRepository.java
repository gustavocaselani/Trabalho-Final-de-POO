package br.edu.atitus.pooavancado.AtividadeFinal.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto>{

	Page<Produto> findByNomeContainingIgnoreCase(Pageable pageable, String nome);

	boolean existsByNomeAndIdNot(String nome, long id);
}
