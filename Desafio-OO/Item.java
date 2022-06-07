package oo.composicao.desafio;

public class Item {

	int quantidade;
	Produto produto;
	
	Item (String nomeDoProduto, double preco, int quantidade) {
		this.quantidade = quantidade;
		this.produto = new Produto(nomeDoProduto, preco);
	}
}
