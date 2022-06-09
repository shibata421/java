package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class CriaConta {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
	}
}
