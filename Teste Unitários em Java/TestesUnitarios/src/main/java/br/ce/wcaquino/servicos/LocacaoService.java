package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ce.wcaquino.dao.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoService {

	private LocacaoDAO dao;
	private SPCService spcService;
	private EmailService emailService;

	public Locacao alugarFilmes(Usuario usuario, Date dataDeLocacao, List<Filme> filmes)
			throws LocadoraException, FilmeSemEstoqueException {
		if (usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}

		if (filmes == null || filmes.size() == 0) {
			throw new LocadoraException("Lista de filmes vazia");
		}
		
		for (int i = 0; i < filmes.size(); i++) {
			if (filmes.get(i).getEstoque() == 0) {
				throw new FilmeSemEstoqueException("Filme sem estoque");
			}
		}

		boolean negativado;
		try {
			negativado = spcService.possuiNegativacao(usuario);
		} catch (Exception e) {
			throw new LocadoraException("Problemas com SPC, tente novamente");
		}

		if (negativado) {
			throw new LocadoraException("Usuário Negativado");
		}

		Locacao locacao = new Locacao();
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(dataDeLocacao);
		adicionarFilmes(filmes, locacao);
		locacao.setValor(calcularValorLocacao(filmes));

		// Entrega no dia seguinte se não for domingo
		Date dataEntrega = adicionarDias(dataDeLocacao, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		dao.salvar(locacao);

		return locacao;
	}

	private void adicionarFilmes(List<Filme> filmes, Locacao locacao) {
		for (int i = 0; i < filmes.size(); i++) {
			locacao.addFilme(filmes.get(i));
		}
	}

	private double calcularValorLocacao(List<Filme> filmes) {
		double valor = 0.00;
		for (int i = 0; i < filmes.size(); i++) {
			double desconto;
			switch (i) {
			case 2:
				desconto = 0.25;
				break;
			case 3:
				desconto = 0.50;
				break;
			case 4:
				desconto = 0.75;
				break;
			case 5:
				desconto = 1.00;
				break;
			default:
				desconto = 0.00;
				break;
			}
			valor += (1 - desconto) * filmes.get(i).getPrecoLocacao();
		}
		return valor;
	}

	public void notificarAtrasos() {
		List<Locacao> locacoes = dao.obterLocacoesPendentes();
		for (Locacao locacao : locacoes) {
			if (locacao.getDataRetorno().before(obterDate())) {
				emailService.notificarAtraso(locacao.getUsuario());
			}
		}
	}

	public Locacao alugarFilmes(Usuario usuario, List<Filme> filmes)
			throws FilmeSemEstoqueException, LocadoraException {
		return alugarFilmes(usuario, obterDate(), filmes);
	}

	public Locacao alugarFilmes(Usuario usuario, Filme... filmes)
			throws FilmeSemEstoqueException, LocadoraException {
		if (filmes[0] == null) {
			return alugarFilmes(usuario, obterDate(), null);
		}
		return alugarFilmes(usuario, obterDate(), Arrays.asList(filmes));
	}

	protected Date obterDate() {
		return new Date();
	}

	public void prorrogarLocacao(Locacao locacao, int dias) {
		Locacao novaLocacao = new Locacao();
		novaLocacao.setUsuario(locacao.getUsuario());
		novaLocacao.setFilmes(locacao.getFilmes());
		novaLocacao.setDataLocacao(obterDate());
		novaLocacao.setDataRetorno(DataUtils.obterDataComDiferencaDias(dias));
		novaLocacao.setValor(locacao.getValor() * dias);
		dao.salvar(novaLocacao);
	}
}