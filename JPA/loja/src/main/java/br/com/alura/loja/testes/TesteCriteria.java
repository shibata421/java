package br.com.alura.loja.testes;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		JPAUtil.popularBD();
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		produtoDao.buscarPorParametrosComCriteria("", null, LocalDate.now());
		
	}
}
