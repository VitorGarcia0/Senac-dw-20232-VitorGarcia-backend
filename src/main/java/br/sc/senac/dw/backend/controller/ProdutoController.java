package br.sc.senac.dw.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.backend.model.entity.Produto;
import br.sc.senac.dw.backend.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos") // shorthand for @Controller and @ResponseBody rolled together
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;  // service = ANTIGO BO
	
	
	@GetMapping(path = "/todos")
	public List<Produto> listarTodosProdutos() {
		//TODO consultar no banco (através de um Repository/DAO)
		return produtoService.listarTodos();
	}
	
	@GetMapping(path = "/{id}")
	public Produto consultarPorId(@PathVariable Integer id) {   //PATH VARIABLE PERMITE PESQUISAR NA URL DIRETO COM O NÚMERO
		//TODO consultar no banco (através de um Repository/DAO)
		return produtoService.consultarPorId(id);
	}

}
