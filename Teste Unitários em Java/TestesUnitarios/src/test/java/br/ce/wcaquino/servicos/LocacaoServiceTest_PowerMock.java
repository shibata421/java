package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static br.ce.wcaquino.matchers.MatcherProprios.caiNumaSegunda;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.ce.wcaquino.dao.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.matchers.MatcherProprios;
import br.ce.wcaquino.utils.DataUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LocacaoService.class, MatcherProprios.class})
public class LocacaoServiceTest_PowerMock {

	@InjectMocks
	private LocacaoService ls;

	@Mock
	private LocacaoDAO dao;
	@Mock
	private SPCService spc;
	@Mock
	private EmailService emailService;

	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
		ls = PowerMockito.spy(ls);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void deveAlugarFilme() throws Exception {
		// cenario
		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(28, 4, 2017));
		Usuario usuario = umUsuario().agora();
		Filme filme = umFilme().comValor(5.0).agora();

		// ação
		Locacao locacao = ls.alugarFilmes(usuario, filme);

		// verificação
//		error.checkThat(locacao.getDataLocacao(), ehHoje());
//		error.checkThat(locacao.getDataRetorno(), MatcherProprios.ehAmanha());
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(
				DataUtils.isMesmaData(
						locacao.getDataLocacao(),
						DataUtils.obterData(28, 4, 2017)),
				is(true));
		error.checkThat(
				DataUtils.isMesmaData(
						locacao.getDataRetorno(),
						DataUtils.obterData(29, 4, 2017)),
				is(true));
	}

	@Test
	public void naoDeveDevolverNoDomingo() throws Exception {
		Usuario usuario = umUsuario().agora();
		Filme filme = umFilme().agora();

		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(29, 4, 2017));

		Locacao locacao = ls.alugarFilmes(usuario, filme);

		assertThat(locacao.getDataRetorno(), caiNumaSegunda());
		PowerMockito.verifyNew(Date.class).withNoArguments();
	}

	
	@Test
	public void deveAlugarFilmeSemCalcularValor() throws Exception {
		//cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		PowerMockito.doReturn(1.0).when(ls, "calcularValorLocacao", filmes);
		
		//acao
		Locacao locacao = ls.alugarFilmes(usuario, filmes);
		
		//verificacao
		assertThat(locacao.getValor(), is(1.0));
		PowerMockito.verifyPrivate(ls).invoke("calcularValorLocacao", filmes);
		
	}
	
	@Test
	public void deveCalcularValorLocacao() throws Exception {
		//cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		//acao
		Double valor = (Double) Whitebox.invokeMethod(ls, "calcularValorLocacao", filmes);

		//verificacao
		assertThat(valor, is(10.0));
	}
}
