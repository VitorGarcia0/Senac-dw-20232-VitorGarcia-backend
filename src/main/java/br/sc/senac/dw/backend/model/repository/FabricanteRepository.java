package br.sc.senac.dw.backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import br.sc.senac.dw.backend.model.entity.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>, JpaSpecificationExecutor<Fabricante> {
	// https://reflectoring.io/spring-data-specifications/

	List<Fabricante> findAllByNomeLike(String nomeInformado);
	
}