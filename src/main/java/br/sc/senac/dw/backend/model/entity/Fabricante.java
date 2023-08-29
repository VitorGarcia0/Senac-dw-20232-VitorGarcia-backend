package br.sc.senac.dw.backend.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	// @JsonIgnore // não vai aparecer no JSON
	private String cnpj;
	
	@JsonBackReference // ANOTAÇÃO PARA RESOLVER O LOOP de gerar o JSON
    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtos;

    public Fabricante() {
		super();
	}

	public Fabricante(Integer id, String nome, String cnpj, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.produtos = produtos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

		
	

}
