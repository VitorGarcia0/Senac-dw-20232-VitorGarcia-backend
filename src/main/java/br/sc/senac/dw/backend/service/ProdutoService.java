package br.sc.senac.dw.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.backend.model.entity.Produto;
import br.sc.senac.dw.backend.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	// Autowired, caso o repository não esteja instaciado, ele vai instanciar;
	// Injenção do OBJETO
	@Autowired
	private ProdutoRepository produtoRepository;    // REPOSITORY == ANTIGO DAO

	
	@Transactional
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}
	
	@Transactional
	public Produto consultarPorId(Integer id) {
		Produto produtoBuscado = produtoRepository.getReferenceById(id.longValue()); // GET REFERENCERED BY ID RETORNA SÓ 1 ID
		
		return produtoBuscado;
	}
	

}
