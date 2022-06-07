package br.com.alura.mvc.mudi.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class PedidoBuilder {

	private Long id;
	private StatusPedido status;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;

	public PedidoBuilder withDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public PedidoBuilder withImagem(String urlImagem) {
		this.urlImagem = urlImagem;
		return this;
	}

	public PedidoBuilder withNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
		return this;
	}

	public PedidoBuilder withUrl(String urlProduto) {
		this.urlProduto = urlProduto;
		return this;
	}
	
	public PedidoBuilder withStauts(StatusPedido status) {
		this.status = status;
		return this;
	}

	public Pedido now() {
		return new Pedido(id, status, valorNegociado, dataDaEntrega, nomeProduto, urlProduto, urlImagem, descricao);
	}
}
