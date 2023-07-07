package br.edu.atitus.pooavancado.AtividadeFinal.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Pedido;
import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Produto;
import br.edu.atitus.pooavancado.AtividadeFinal.services.PedidoService;
import br.edu.atitus.pooavancado.AtividadeFinal.services.GenericService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido>{

	final PedidoService pedidoService;
	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}
	
	@Override
	GenericService<Pedido> getService() {
		return pedidoService;
	}
	
	@GetMapping()
	public ResponseEntity<Object> getEntidades(@PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.ASC) Pageable pageable) throws Exception {
		Page<Pedido> pedidos = pedidoService.find(pageable);
			return ResponseEntity.status(HttpStatus.OK).body(pedidos);
	}
}
