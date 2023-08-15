package br.sc.senac.dw.backend.model;

import java.time.LocalDate;

import lombok.Data;

@Data

public class Produto {
	
	private int id;
	private String nome;
	private String fabricante;
	private double valor;
	private double peso;
	private LocalDate dataCadastro;

	public Produto(String nome, String fabricante, double valor, double peso, LocalDate dataCadastro) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
		this.peso = peso;
		this.dataCadastro = dataCadastro;
	}

}
