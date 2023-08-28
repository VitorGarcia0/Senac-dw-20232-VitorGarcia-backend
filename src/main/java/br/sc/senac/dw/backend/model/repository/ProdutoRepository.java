package br.sc.senac.dw.backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.backend.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	// https://reflectoring.io/spring-data-specifications/
	
	List<Produto> findAllbyNameLike(String nomeInformado);

	List<Produto> findAll(Specification<Produto> specification);

}
