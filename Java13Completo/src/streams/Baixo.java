package streams;

public class Baixo {

	private String modelo;
	private double preco;
	private boolean boaQualidade;
	
	public Baixo(String modelo, double preco, boolean boaQualidade) {
		this.modelo = modelo;
		this.preco = preco;
		this.boaQualidade = boaQualidade;
	}

	public String getNome() {
		return modelo;
	}

	public void setNome(String nome) {
		this.modelo = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isBoaQualidade() {
		return boaQualidade;
	}

	public void setBoaQualidade(boolean boaQualidade) {
		this.boaQualidade = boaQualidade;
	}
	
	
	
}
