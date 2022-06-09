package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println(typedQuery.getSingleResult());
	}
}
