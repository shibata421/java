package br.com.alura.gerenciador.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {

	private Integer id;
	private String nome;
	private LocalDate dataAbertura = LocalDate.now();
	
	public Empresa() {}
	
	public Empresa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setData(String dataAbertura) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataAbertura = LocalDate.parse(dataAbertura, formatter);
	}
}
