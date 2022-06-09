package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT m FROM Movimentacao AS m JOIN m.categorias AS c "
				+ "WHERE c = :pCategoria ORDER BY m.valor DESC" ;
		
		Categoria categoria = new Categoria();
		categoria.setId(5L);
		
		List<Movimentacao> movimentacoes = em.createQuery(jpql, Movimentacao.class)
				.setParameter("pCategoria", categoria)
				.getResultList();
		
		movimentacoes.forEach(m -> System.out.println(m.getDescricao()));
	}
}
