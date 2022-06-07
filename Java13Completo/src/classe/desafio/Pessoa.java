package classe.desafio;

public class Pessoa {

	String nomePessoa;
	double pesoPessoa;
	
	
	public Pessoa(String nomePessoa, double pesoPessoa) {
		this.nomePessoa = nomePessoa;
		this.pesoPessoa = pesoPessoa;
	}


	void comer(Comida c) {
		pesoPessoa += c.pesoComida;
	}
}
