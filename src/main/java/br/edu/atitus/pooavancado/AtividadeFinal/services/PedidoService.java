package br.edu.atitus.pooavancado.AtividadeFinal.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Pedido;
import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;


public interface PedidoService extends GenericService<Pedido>{
	
	Page<Pedido> find(Pageable pageable);
}
