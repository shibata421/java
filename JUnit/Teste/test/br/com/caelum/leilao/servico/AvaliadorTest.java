package br.com.caelum.leilao.servico;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.matchers.LeilaoMatcher;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		joao = new Usuario("João");
		jose = new Usuario("José");
		maria = new Usuario("Maria");
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
		
		leiloeiro.avalia(leilao);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 novo")
				.lance(maria, 3000.0)
				.lance(jose, 2000.0)
				.lance(joao, 1000.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		assertThat(leiloeiro.getMaiorLance(), is(3000.0));
		assertThat(leiloeiro.getMenorLance(), is(1000.0));
	}

	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 novo")
				.lance(maria, 200.0)
				.lance(jose, 450.0)
				.lance(joao, 120.0)
				.lance(maria, 700.0)
				.lance(jose, 630.0)
				.lance(joao, 230.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		assertThat(leiloeiro.getMaiorLance(), is(700.0));
		assertThat(leiloeiro.getMenorLance(), is(120.0));		
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 novo")
				.lance(joao, 100.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		assertThat(leiloeiro.getMaiorLance(), is(100.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(100.0));
	}

	@Test
	public void devePegarApenasOs3MaioresLances() {
		// parte 1 cenário
		Usuario nina = new Usuario("Nina");
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 novo")
				.lance(maria, 3000.0)
				.lance(jose, 2000.0)
				.lance(joao, 1000.0)
				.lance(nina, 9000.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		List<Double> maioresLances = leiloeiro.get3MaioresLances();
		assertThat(maioresLances.size(), is(3));
		assertThat(maioresLances, hasItems(9000.0, 3000.0, 2000.0));
	}

	@Test
	public void devePegarApenasOs2MaioresLancesQuandoHaApenas2Lances() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 novo")
				.lance(joao, 1000.0)
				.lance(jose, 2000.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		List<Double> maioresLances = leiloeiro.get3MaioresLances();
		assertThat(maioresLances.get(0), is(2000.0));
		assertThat(maioresLances.get(1), is(1000.0));
	}

	@Test
	public void deveDevolverAMediaDosLances() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();

		// parte 2 acao
		leiloeiro.avalia(leilao);

		// parte 3 validacao
		double mediaEsperada = (250 + 300 + 400) / 3.0;

		assertThat(leiloeiro.getMedia(), is(mediaEsperada));
	}
	
	@Test
	public void usaLeilaoMatcher() {
		// parte 1 cenário
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.constroi();
		
		Lance lance = new Lance(maria, 500.0);
		leilao.propoe(lance);
		
		// parte 2 acao
		leiloeiro.avalia(leilao);
		
		// parte 3 validacao
		assertThat(leilao, LeilaoMatcher.temUmLance(lance));
	}
}
