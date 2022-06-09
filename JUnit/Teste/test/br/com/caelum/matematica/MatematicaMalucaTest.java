package br.com.caelum.matematica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatematicaMalucaTest {

	private MatematicaMaluca math;

	@Before
	public void setup() {
		math = new MatematicaMaluca();		
	}
	
	@Test
	public void shouldMultiplyBy4() {
		assertEquals(160, math.contaMaluca(40));
	}
	
	@Test
	public void shouldMultiplyBy3() {
		assertEquals(90, math.contaMaluca(30));
	}
	
	@Test
	public void shouldMultiplyBy2() {
		assertEquals(18, math.contaMaluca(9));
	}

}
