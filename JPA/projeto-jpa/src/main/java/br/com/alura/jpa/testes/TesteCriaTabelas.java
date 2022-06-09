package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.util.JPAUtil;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.close();
	}
}
 