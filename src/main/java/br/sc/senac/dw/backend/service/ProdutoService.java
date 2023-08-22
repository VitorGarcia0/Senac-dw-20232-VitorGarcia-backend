package br.sc.senac.dw.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.backend.exception.CampoInvalidoException;
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
	public Produto consultarPorId(Long id) {
		// GET REFERENCERED BY ID RETORNA SÓ 1 ID
		
		return produtoRepository.findById(id.longValue()).get();
	}

	public Produto inserir(Produto novoProduto) throws CampoInvalidoException{
		validarCamposObrigatorios(novoProduto);
		return produtoRepository.save(novoProduto);
	}

	public Object atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(produtoParaAtualizar);
		return produtoRepository.save(produtoParaAtualizar);
	}

	public boolean excluir(Integer id) {
		produtoRepository.deleteById(id.longValue());
		return true;
	}
	
	
	private void validarCamposObrigatorios(Produto produto) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(produto.getNome(), "nome");
		mensagemValidacao += validarCampoString(produto.getFabricante(), "Fabricante");
		mensagemValidacao += validarCampoDouble(produto.getValor(), "Valor");
		mensagemValidacao += validarCampoDouble(produto.getPeso(), "Peso");
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
		
	}

	private String validarCampoString(String valorCampo, String nomeCampo  ) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
	
	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		// TODO Auto-generated method stub
		return "";
	}

}
