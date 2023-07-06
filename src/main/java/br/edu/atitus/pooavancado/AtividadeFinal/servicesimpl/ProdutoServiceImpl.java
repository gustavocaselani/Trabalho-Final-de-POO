package br.edu.atitus.pooavancado.AtividadeFinal.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.GenericRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.repositories.ProdutoRepository;
import br.edu.atitus.pooavancado.AtividadeFinal.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	final ProdutoRepository produtoRepository;
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public GenericRepository<Produto> getRepository() {
		return produtoRepository;
	}
	
	public Page<Produto> findByNome(Pageable pageable, String nome){
		return ((ProdutoRepository) getRepository()).findByNomeContainingIgnoreCase(pageable, nome);
	}

	@Override
	public void validarSave(Produto objeto) throws Exception {
		if (objeto.getNome() == null || objeto.getNome().isEmpty())
			throw new Exception("Deve ser informado um Nome para o Produto.");
		if (objeto.getValorUnitario() == 0)
			throw new Exception("Deve ser informado o Valor Unitário do Produto.");
		if (objeto.getUnidadeMedida() == null || objeto.getUnidadeMedida().isEmpty())
			throw new Exception("Deve ser informada a Unidade de Medida do Produto.");
		if (objeto.getDescricao() == null || objeto.getDescricao().isEmpty())
			throw new Exception("Deve ser informada uma Descrição para o Produto.");
	}
}
