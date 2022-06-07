package fundamentos.operadores;

public class DesafioLogicos {
	
	public static void main(String[] args) {
		// Trabalho na terça (V ou F)
		// Trabalho na quinta (V ou F)
		
		boolean trabalhoTerca = false;
		boolean trabalhoQuinta = true;
		
		boolean tv32Polegadas = (trabalhoTerca ^ trabalhoQuinta);
		boolean tv50Polegadas = (trabalhoTerca && trabalhoQuinta);
		boolean tomouSorvete = (trabalhoTerca || trabalhoQuinta);
		
		
		System.out.println("Comprou TV de 32 polegadas? " + tv32Polegadas);
		System.out.println("Comprou TV de 50 polegadas? " + tv50Polegadas);
		System.out.println("Tomou sorvete? " + tomouSorvete);
		System.out.println("A família ficou em casa? " + !tomouSorvete);
	}
}
