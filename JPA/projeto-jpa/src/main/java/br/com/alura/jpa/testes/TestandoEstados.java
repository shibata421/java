package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TestandoEstados {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setNumero(654321);
		
		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
}