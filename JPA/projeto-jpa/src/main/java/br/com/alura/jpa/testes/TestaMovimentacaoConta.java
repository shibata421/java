package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 3L);
		Conta conta = movimentacao.getConta();
		int quantidadeDeMovimentacoes = conta.getMovimentacoes().size();
				
		System.out.println(quantidadeDeMovimentacoes);
		System.out.println(conta.getTitular());
	}
}
