package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300));
		movimentacao.setCategorias(List.of(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem a RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400));
		movimentacao2.setCategorias(List.of(categoria, categoria2));
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
