package br.ce.wcaquino.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Locacao {

	private Usuario usuario;
	private List<Filme> filmes;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;
	
	/*
	 * 
	 * CONSTRUTORES
	 * 
	 * */
	public Locacao() {
		this.filmes = new ArrayList<>();
		this.valor = 0.0;
	}
	
	/*
	 * 
	 * GETTERS & SETTERS
	 * 
	 * */
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	public List<Filme> getFilmes() {
		return Collections.unmodifiableList(filmes);
	}
	public void addFilme(Filme filme) {
		this.filmes.add(filme);
	}
}