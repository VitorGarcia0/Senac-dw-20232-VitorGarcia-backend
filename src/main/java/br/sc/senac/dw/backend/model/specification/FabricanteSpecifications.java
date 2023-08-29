package br.sc.senac.dw.backend.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.backend.model.entity.Fabricante;
import br.sc.senac.dw.backend.model.seletor.FabricanteSeletor;
import jakarta.persistence.criteria.Predicate;

public class FabricanteSpecifications {

	public static Specification<Fabricante> comFiltros(FabricanteSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			// PESQUISAR Por parte do nome do Fabricante
			if (seletor.getNome() != null) {
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
							+ seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getCnpj() != null) {
				predicates.add(cb.like(root.get("cnpj"), "%" + seletor.getCnpj()+ "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));

		};

	}
}
