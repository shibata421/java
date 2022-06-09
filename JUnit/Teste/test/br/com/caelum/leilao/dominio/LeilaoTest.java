package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

	private Leilao leilao;

	@Before
	public void setup() {
		leilao = new Leilao("Macbook Pro 15");		
	}
	
	@Test
	public void deveReceberUmLance() {
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("mario"), 500.0));
		assertEquals(1, leilao.getLances().size());
		assertEquals(500.0, leilao.getLances().get(0).getValor(), 0.001);
	}
	
	@Test
	public void deveReceberVariosLances() {
		leilao.propoe(new Lance(new Usuario("mario"), 500.0));
		leilao.propoe(new Lance(new Usuario("mario2"), 4100.0));
		assertEquals(2, leilao.getLances().size());
		assertEquals(500.0, leilao.getLances().get(0).getValor(), 0.001);
		assertEquals(4100.0, leilao.getLances().get(1).getValor(), 0.001);
	}
	
	@Test
	public void umaPessoaNaoPodeDarDoisLancesSeguidosDoMesmoUsuario() {
		Usuario mario = new Usuario("Mario");
		
		leilao.propoe(new Lance(mario, 500.0));
		leilao.propoe(new Lance(mario, 4100.0));
		assertEquals(1, leilao.getLances().size());
		assertEquals(500.0, leilao.getLances().get(0).getValor(), 0.001);
	}
	
	@Test
	public void umaPessoaNaoPodeDarMaisDoQue5Lances() {
		Usuario mario = new Usuario("Mario");
		Usuario luigi = new Usuario("MarioVerde");
		
		for(int i = 0; i < 6; i++) {
			leilao.propoe(new Lance(mario, 505.0 + i*100));
			leilao.propoe(new Lance(luigi, 600.0 + i*100));			
		}
		
		assertEquals(10, leilao.getLances().size());
	}
	
	@Test
	public void deveDobrarOUltimoLanceDado() {
		Usuario mario = new Usuario("Mario");
		Usuario luigi = new Usuario("MarioVerde");
		leilao.propoe(new Lance(mario, 500.0));
		leilao.propoe(new Lance(luigi, 600.0));
		leilao.dobraLance(mario);
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(2).getValor(), 0.001);
	}
	
	@Test
	public void naoDeveDobrarSeNaoTiverLance() {
		Usuario mario = new Usuario("Mario");
		leilao.dobraLance(mario);
		
		assertEquals(0, leilao.getLances().size());
	}
	
	@Test
	public void naoDeveDobrarSeFizerLanceEmSequencia() {
		Usuario mario = new Usuario("Mario");
		leilao.propoe(new Lance(mario, 500.0));
		leilao.dobraLance(mario);
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(500.0, leilao.getLances().get(0).getValor(), 0.001);
	}
	
	@Test
	public void naoDeveDobrarSeJaTiver5Lances() {
		Usuario mario = new Usuario("Mario");
		Usuario luigi = new Usuario("MarioVerde");
		
		for(int i = 0; i < 5; i++) {
			leilao.propoe(new Lance(mario, 505.0 + i*100));
			leilao.propoe(new Lance(luigi, 600.0 + i*100));			
		}
		
		leilao.dobraLance(mario);
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(1000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.001);
	}

}
