package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.dao.ContaDAO;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		Conta contaDoLeonardo = dao.buscar(1L);
		
		em.getTransaction().begin();
		
		contaDoLeonardo.setSaldo(20.0);
		dao.alterar(contaDoLeonardo);

		em.getTransaction().commit();
		em.close();
	}
}
