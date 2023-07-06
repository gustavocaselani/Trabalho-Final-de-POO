package br.edu.atitus.pooavancado.AtividadeFinal.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;
import br.edu.atitus.pooavancado.AtividadeFinal.services.GenericService;
import br.edu.atitus.pooavancado.AtividadeFinal.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto> {

	final ProdutoService produtoService;
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@GetMapping()
	public ResponseEntity<Object> getEntidades(@PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.ASC) Pageable pageable, @RequestParam String nome) throws Exception {
		Page<Produto> produtos = produtoService.findByNome(pageable, nome);
			return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}

	@Override
	GenericService<Produto> getService() {
		return produtoService;
	}
}
