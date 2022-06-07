package br.ce.wcaquino.servicos;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;

	@Spy
	private Calculadora calcSpy;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void devoMostrarDiferencaEntreMockESpy() {
		when(calcMock.somar(1, 2)).thenCallRealMethod();
		when(calcSpy.somar(1, 2)).thenReturn(8);
		Mockito.doReturn(5).when(calcSpy).somar(1, 2);
		Mockito.doNothing().when(calcSpy).imprime();
		
		System.out.println(calcMock.somar(1, 2));
		System.out.println(calcSpy.somar(1, 2));
		
		System.out.println("Mock:");
		calcMock.imprime();
		System.out.println("Spy:");
		calcSpy.imprime();
	}
	
	@Test
	public void test() {
		Calculadora calc = Mockito.mock(Calculadora.class);
		
		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, (calc.somar(1, 8)));
//		System.out.println(argCapt.getAllValues());
	}
}
