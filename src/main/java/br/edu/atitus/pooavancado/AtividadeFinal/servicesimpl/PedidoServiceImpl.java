package br.edu.atitus.pooavancado.AtividadeFinal.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Pedido;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.PedidoRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	final PedidoRepository pedidoRepository;
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository= pedidoRepository;
	}
	
	@Override
	public PedidoRepository getRepository() {
		return pedidoRepository;
	}

	@Override
	public void validarSave(Pedido objeto) throws Exception {
		if (objeto.getProduto() == null)
			throw new Exception("Deve ser informado um Produto.");
		if (objeto.getData() == null)
			throw new Exception("Deve ser informada uma Data.");
		if (objeto.getQuantidade() == 0)
			throw new Exception("Deve ser informada uma Quantidade.");
	}

	@Override
	public Page<Pedido> find(Pageable pageable) {
		return ((PedidoRepository) getRepository()).findAll(pageable);
	}
}
