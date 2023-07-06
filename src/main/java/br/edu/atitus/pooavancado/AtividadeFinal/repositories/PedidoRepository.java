package br.edu.atitus.pooavancado.AtividadeFinal.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Pedido;
import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;


@Repository
public interface PedidoRepository extends GenericRepository<Pedido>{
	
	Page<Pedido> findAll(Pageable pageable);
}
