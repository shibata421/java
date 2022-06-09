package produtos;

public class Produto {

	private final String nome;
	private final double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public double getPrecoComImposo() {
		return preco * 1.1;
	}

}
