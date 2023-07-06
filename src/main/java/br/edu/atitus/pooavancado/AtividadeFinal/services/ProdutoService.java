package br.edu.atitus.pooavancado.AtividadeFinal.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;

public interface ProdutoService extends GenericService<Produto>{

	Page<Produto> findByNome(Pageable pageable, String nome);
}
