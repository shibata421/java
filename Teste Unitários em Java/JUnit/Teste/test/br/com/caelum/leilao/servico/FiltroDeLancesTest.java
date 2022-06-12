package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class FiltroDeLancesTest {

	private Usuario joao;
	private FiltroDeLances filtro;

	@Before
	public void setup() {
		joao = new Usuario("Joao");
		filtro = new FiltroDeLances();
	}

	@Test
	public void deveSelecionarLancesEntre1000E3000() {
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 2000), new Lance(joao, 1000),
				new Lance(joao, 3000), new Lance(joao, 800)));

		assertEquals(1, resultado.size());
		assertEquals(2000, resultado.get(0).getValor(), 0.00001);
	}

	@Test
	public void deveSelecionarLancesEntre500E700() {
		List<Lance> resultado = filtro.filtra(
				Arrays.asList(new Lance(joao, 600), new Lance(joao, 500), new Lance(joao, 700), new Lance(joao, 800)));

		assertEquals(1, resultado.size());
		assertEquals(600, resultado.get(0).getValor(), 0.00001);
	}

	@Test
	public void deveSelecionarLancesAcimaDe5000() {
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 6000), new Lance(joao, 5000),
				new Lance(joao, 3000), new Lance(joao, 4000)));

		assertEquals(1, resultado.size());
		assertEquals(6000, resultado.get(0).getValor(), 0.00001);
	}

	@Test
	public void naoDeveSelecionarLances() {
		List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 500), new Lance(joao, 700),
				new Lance(joao, 3000), new Lance(joao, 5000), new Lance(joao, 1000)));

		assertEquals(0, resultado.size());
	}

	@Test
	public void DeveSelecionarTodosLances() {
		List<Lance> lances = Arrays.asList(
				new Lance(joao, 501), 
				new Lance(joao, 699), 
				new Lance(joao, 2999),
				new Lance(joao, 5001), 
				new Lance(joao, 1001));
		
		List<Lance> resultado = filtro.filtra(lances);

		assertEquals(5, resultado.size());
		assertEquals(501, resultado.get(0).getValor(), 0.01);
		assertEquals(699, resultado.get(1).getValor(), 0.01);
		assertEquals(2999, resultado.get(2).getValor(), 0.01);
		assertEquals(5001, resultado.get(3).getValor(), 0.01);
		assertEquals(1001, resultado.get(4).getValor(), 0.01);
	}
}
