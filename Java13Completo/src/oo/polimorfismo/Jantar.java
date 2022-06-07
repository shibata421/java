package oo.polimorfismo;

public class Jantar {

	public static void main(String[] args) {
		
		Pessoa convidado = new Pessoa(99.65);
		System.out.println(convidado.getPeso());
		
		Comida ingrediente = new Arroz(0.20);
		convidado.comer(ingrediente);
		
		ingrediente = new Feijao(0.10);
		convidado.comer(ingrediente);
		
		System.out.println(convidado.getPeso());
	
		Sorvete sobremesa = new Sorvete(0.4);
		
		convidado.comer(sobremesa);
		System.out.println(convidado.getPeso());
		
	}
}
