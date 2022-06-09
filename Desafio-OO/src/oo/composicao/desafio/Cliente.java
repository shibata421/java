package oo.composicao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	String nomeDoCliente;
	final List<Compra> compras = new ArrayList<Compra>();
	
	Cliente(String nome){
		this.nomeDoCliente = nome;
	}
	
	void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}
	
	double totalDasCompras() {
		double total = 0;
		
		for (Compra compra : compras) {
			total += compra.totalDaCompra();
		}
		
		return total;
	}

}
