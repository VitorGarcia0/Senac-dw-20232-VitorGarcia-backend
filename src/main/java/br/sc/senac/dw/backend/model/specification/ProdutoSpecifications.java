package br.sc.senac.dw.backend.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.backend.model.entity.Produto;
import br.sc.senac.dw.backend.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoSpecifications {

	/*
	 * * root: é uma referência à entidade raiz que você está consultando. No
	 * contexto do JPA, isso representa a tabela do banco de dados correspondente à
	 * entidade Produto.
	 * 
	 * query: O parâmetro query representa a consulta JPA que está sendo construída.
	 * Ele é usado para adicionar cláusulas WHERE, JOIN, ORDER BY, entre outras, à
	 * consulta.
	 * 
	 * cb (CriteriaBuilder): é uma interface que oferece métodos para construção de
	 * cláusulas de consulta de forma programática. Você usa métodos deste objeto
	 * para criar expressões de predicado, funções agregadas e outras partes da
	 * consulta.
	 */

	public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getNome() != null) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}
			// Filtros pelo PESO
			if (seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
				// WHERE peso BETWEEN min AND max
				predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), seletor.getPesoMaximo()));

			} else if (seletor.getPesoMinimo() != null) {
				// WHERE peso >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));

			} else if (seletor.getPesoMaximo() != null) {
				// WHERE peso <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
			}

			if (seletor.getFabricante() != null) {
				predicates.add(cb.like(root.join("fabricante").get("nome"), 
								"%" + seletor.getFabricante() + "%"	));
			}
			// Filtros pelo VALOR
			if (seletor.getValorMinimo() != null && seletor.getValorMinimo() != null) {
				predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), seletor.getValorMaximo()));
			
			}
//				else if (seletor.getValorMinimo() != null) {
//				// WHERE peso >= min
//				predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
//	
//			} else if (seletor.getValorMaximo() != null) {
//				// WHERE peso <= max
//				predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
//			}
			
			if (seletor.getCnpjFabricante() != null && !seletor.getCnpjFabricante().isEmpty()) {
				predicates.add(cb.equal(root.join("fabricante").get("cnpj"), seletor.getCnpjFabricante()));
			}


//	            Desenvolver em ProdutoSeletor e ProdutoEspecification a busca de produtos com os seguintes filtros
//	            - Peso (máximo e mínimo)
//	            - Valor (máximo e mínimo)
//	            - CNPJ do Fabricante (com '=' )

			return cb.and(predicates.toArray(new Predicate[0]));
		};
}}
