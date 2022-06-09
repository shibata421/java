package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua do Ouvidor, 50");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
