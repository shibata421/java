package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.dao.ContaDAO;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setAgencia(12345);
		conta.setNumero(54321);
		conta.setSaldo(100.0);
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		dao.salvar(conta);
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		conta = em.merge(conta);
		conta.setSaldo(1000.0);
		em.getTransaction().commit();
		em.close();
	}
}
