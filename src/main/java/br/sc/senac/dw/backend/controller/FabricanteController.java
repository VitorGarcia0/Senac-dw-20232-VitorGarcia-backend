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
import br.sc.senac.dw.backend.model.entity.Fabricante;
import br.sc.senac.dw.backend.service.FabricanteService;

@RestController
@RequestMapping(path = "/api/fabricante") // shorthand for @Controller and @ResponseBody rolled together
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping
	public List<Fabricante> listarTodosFabricantes() {
		//TODO consultar no banco (através de um Repository/DAO)
		return fabricanteService.listarTodos();
	}
	
	@PostMapping
	public Fabricante salvar(@RequestBody Fabricante novoFabricante) throws CampoInvalidoException {
		return fabricanteService.inserir(novoFabricante);
	}
	
	@PutMapping
	public boolean atualizar(@RequestBody Fabricante fabricanteParaAtualizar) throws CampoInvalidoException {
		return fabricanteService.atualizar(fabricanteParaAtualizar) != null;
		
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return fabricanteService.excluir(id);
	}

	


}
