package oo.heranca.desafio;

public class Carro {

	public final double VELOCIDADE_MAXIMA;
	protected double velocidade;
	private double delta = 5;
	
	protected Carro (double velocidadeMaxima){
		VELOCIDADE_MAXIMA = velocidadeMaxima;
	}
	

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public boolean acelerar() {
		if (this.velocidade + getDelta() > VELOCIDADE_MAXIMA) {
			this.velocidade = VELOCIDADE_MAXIMA;
		} else {
			this.velocidade += getDelta();
		}
		return true;
	}
	
	public boolean frear() {
		if (this.velocidade > 5.0) {
			this.velocidade -= 5;
			return true;
		} else if (this.velocidade > 0.0) {
			this.velocidade = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () {
		return "A velocidade atual é de " + this.velocidade + "km/h";
	}
}
