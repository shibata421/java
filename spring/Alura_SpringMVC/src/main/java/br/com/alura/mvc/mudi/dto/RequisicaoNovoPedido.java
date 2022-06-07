package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.builder.PedidoBuilder;
import br.com.alura.mvc.mudi.model.Pedido;

public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;

	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "RequisicaoNovoPedido [nomeProduto=" + nomeProduto + ", urlProduto=" + urlProduto + ", urlImagem="
				+ urlImagem + ", descricao=" + descricao + "]";
	}

	public Pedido toPedido() {
		return new PedidoBuilder()
				.withDescricao(descricao)
				.withImagem(urlImagem)
				.withNome(nomeProduto)
				.withUrl(urlProduto)
				.now();
	}

	
}
