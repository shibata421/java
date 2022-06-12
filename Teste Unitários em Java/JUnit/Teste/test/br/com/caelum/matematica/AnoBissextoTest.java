package br.com.caelum.matematica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnoBissextoTest {
	
	private AnoBissexto bissexto;

	@Before
	public void setup() {
		bissexto = new AnoBissexto();
	}

	@Test
	public void naoDeveSerBissexto2021() {
		assertFalse(bissexto.ehBissexto(2021));
	}
	
	@Test
	public void naoDeveSerBissexto1900() {
		assertFalse(bissexto.ehBissexto(1900));
	}
	
	@Test
	public void naoDeveSerBissexto2000() {
		assertTrue(bissexto.ehBissexto(2000));
	}

}
