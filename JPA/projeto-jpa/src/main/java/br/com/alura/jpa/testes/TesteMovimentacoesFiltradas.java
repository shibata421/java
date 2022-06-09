package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteMovimentacoesFiltradas {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		List<Movimentacao> movimentacoes = dao.getMovimentacoesFiltradasPorData(12, null, 2017);
		movimentacoes.forEach(m -> {
			System.out.println("Descricao -> " + m.getDescricao());
			System.out.println("Valor -> " + m.getValor());
			System.out.println("-------------------------------");
		});
	}
}
