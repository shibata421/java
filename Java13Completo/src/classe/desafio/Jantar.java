package classe.desafio;

public class Jantar {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa ("Fernando", 113);
		Comida c1 = new Comida("Arroz", 0.20);
		Comida c2 = new Comida("Feijao", 0.40);
		
		System.out.println(p.pesoPessoa);

		p.comer(c1);
		p.comer(c2);
		System.out.println(p.pesoPessoa);
		
		
	}
}
