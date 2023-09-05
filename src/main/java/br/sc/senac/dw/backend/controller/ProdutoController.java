package br.sc.senac.dw.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.backend.exception.CampoInvalidoException;
import br.sc.senac.dw.backend.model.entity.Produto;
import br.sc.senac.dw.backend.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.backend.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos") // shorthand for @Controller and @ResponseBody rolled together
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600) // Por padrão para permitir o servidor algumas origens
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;  // service = ANTIGO BO
	
	// GET: usado para consultas
	@GetMapping
	public List<Produto> listarTodosProdutos() {
		//TODO consultar no banco (através de um Repository/DAO)
		return produtoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Produto consultarPorId(@PathVariable Integer id) {   //PATH VARIABLE PERMITE PESQUISAR NA URL DIRETO COM O NÚMERO
		//TODO consultar no banco (através de um Repository/DAO)
		return produtoService.consultarPorId(id.longValue());
	}
	
	/**
	 * Método POST: geralmente utilizado para inserir novos registros
	 * Parâmetros são enviados no corpo da requisição HTTP, 
	 * para isso usamos a anotação @RequestBody
	 * 
	 * @return o produto salvo, com id preenchido
	 * @throws CampoInvalidoException 
	 */
	
	@PostMapping("/filtro")
	public List<Produto> listarComSeletor(@RequestBody ProdutoSeletor seletor){
		return produtoService.listarComSeletor(seletor);
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) throws CampoInvalidoException {
		return produtoService.inserir(novoProduto);
	}	
	
	/**
	 * Método PUT: utilizado para atualizar registros. 
	 * Muitas vezes é usado o POST em seu lugar
	 * Parâmetros são enviados no corpo da requisição HTTP, 
	 * para isso usamos a anotação @RequestBody
	 * 
	 * @return um booleano indicando se o produto em questão foi atualizado
	 * @throws CampoInvalidoException 
	 */
	
	@PutMapping
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException {
		return produtoService.atualizar(produtoParaAtualizar) != null;
		
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return produtoService.excluir(id);
	}
				
			
	

}
