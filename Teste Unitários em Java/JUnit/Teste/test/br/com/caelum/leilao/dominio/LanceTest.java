package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {

	private Usuario joao;

	@Before
	public void setup() {
		joao = new Usuario("João");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLancesComValorZero() {
		new Lance(joao, 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveAceitarLancesComValorNegativo() {
		new Lance(joao, -1.0);
	}
	
}
