package oo.composicao.desafio;

import java.util.Locale;

public class ClienteTeste {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Compra compra1 = new Compra();
		Compra compra2 = new Compra();
		
		Item item1 = new Item("Caixa com 12 Ovos", 6.50, 2);
		Item item2 = new Item("Pão de forma", 3.10, 1);
		Item item3 = new Item("Bolacha", 2.55, 3);
		Item item4 = new Item("Amaciante", 10.10, 1);

		Cliente cliente = new Cliente("Fernando");
		
		compra1.adicionarItem(item1);
		compra1.adicionarItem(item2);
		
		compra2.adicionarItem(item1);
		compra2.adicionarItem(item3);
		compra2.adicionarItem(item4);
		
		System.out.println("O total da compra 1 é "
				+ String.format("%.2f", compra1.totalDaCompra()));
		System.out.println("O total da compra 2 é "
				+ String.format("%.2f", compra2.totalDaCompra()));
		
		cliente.adicionarCompra(compra1);
		cliente.adicionarCompra(compra2);
		
		System.out.println("O total das compras de " 
				+ cliente.nomeDoCliente 
				+ " é "
				+ cliente.totalDasCompras());;
		
	}
}
