package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		Root<Movimentacao> root = query.from(Movimentacao.class);

		List<Predicate> predicates = new ArrayList<>();
		
		if(dia != null) {
			Expression<Integer> function = builder.function("DAY", Integer.class, root.<LocalDateTime>get("data"));
			predicates.add(builder.equal(function, dia));
		}
		
		if(mes != null) {
			Expression<Integer> function = builder.function("MONTH", Integer.class, root.<LocalDateTime>get("data"));
			predicates.add(builder.equal(function, mes));
		}
		
		if(ano != null) {
			Expression<Integer> function = builder.function("YEAR", Integer.class, root.<LocalDateTime>get("data"));
			predicates.add(builder.equal(function, ano));
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		return Collections.unmodifiableList(em.createQuery(query).getResultList());
	}
	
	public List<MediaComData> getMediasDiarias() {
		return Collections.unmodifiableList(
				em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class)
				.getResultList());
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m";

		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

}
