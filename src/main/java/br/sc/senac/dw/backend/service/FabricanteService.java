package br.sc.senac.dw.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.backend.exception.CampoInvalidoException;
import br.sc.senac.dw.backend.model.entity.Fabricante;
import br.sc.senac.dw.backend.model.repository.FabricanteRepository;
import jakarta.transaction.Transactional;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository; // REPOSITORY == ANTIGO DAO

	@Transactional
	public List<Fabricante> listarTodos() {
		return fabricanteRepository.findAll();
	}
		
	public Fabricante inserir(Fabricante novoFabricante) throws CampoInvalidoException {
		validarCamposObrigatorios(novoFabricante);
		return fabricanteRepository.save(novoFabricante);
	}

	public Object atualizar(Fabricante fabricanteParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(fabricanteParaAtualizar);
		return fabricanteRepository.save(fabricanteParaAtualizar);
	}

	public boolean excluir(Integer id) {
		fabricanteRepository.deleteById(id.longValue());
		return true;
	}

	private void validarCamposObrigatorios(Fabricante fabricante) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(fabricante.getNome(), "nome");
		mensagemValidacao += validarCampoString(fabricante.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(fabricante.getCep(), "cep");
		mensagemValidacao += validarCampoString(fabricante.getCidade(), "cidade");
		mensagemValidacao += validarCampoString(fabricante.getUf(), "uf");
		
		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}

	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}


}
