package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		String jpql = "SELECT m FROM Movimentacao AS m WHERE m.conta = :pConta ORDER BY m.valor DESC";

		Conta conta = new Conta();
		conta.setId(1L);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Movimentacao> lista = em.createQuery(jpql, Movimentacao.class)
				.setParameter("pConta", conta)
				.getResultList();
		
		lista.forEach(m -> System.out.println(m.getDescricao()));
		em.close();
	}
}
