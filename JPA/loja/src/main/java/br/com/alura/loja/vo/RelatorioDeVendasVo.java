package br.com.alura.loja.vo;

import java.time.LocalDate;

// Vo -> Value Object
public class RelatorioDeVendasVo {

	private String produtoNome;
	private Long quantidade;
	private LocalDate ultimaVenda;

	public RelatorioDeVendasVo(String produtoNome, Long quantidade, LocalDate ultimaVenda) {
		this.produtoNome = produtoNome;
		this.quantidade = quantidade;
		this.ultimaVenda = ultimaVenda;
	}

	public String getProduto() {
		return produtoNome;
	}

	public void setProduto(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getUltimaVenda() {
		return ultimaVenda;
	}

	public void setUltimaVenda(LocalDate ultimaVenda) {
		this.ultimaVenda = ultimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [produtoNome=" + produtoNome + ", quantidade=" + quantidade + ", ultimaVenda="
				+ ultimaVenda + "]";
	}

}
