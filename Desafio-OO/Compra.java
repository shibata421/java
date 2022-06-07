package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	final List<Item> itens = new ArrayList<Item>();
	
	void adicionarItem(Item item) {
		this.itens.add(item);
	}
	
	void adicionarItem(String nome, double preco, int quantidade) {
		adicionarItem(new Item(nome, preco, quantidade));
	}
	
	double totalDaCompra () {
		double total = 0;
		
		for (Item item : itens) {
			total += item.quantidade * item.produto.preco;
		}
		
		return total;
	}
}
