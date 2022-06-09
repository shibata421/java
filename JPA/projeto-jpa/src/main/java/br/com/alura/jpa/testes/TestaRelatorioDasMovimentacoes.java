package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.util.JPAUtil;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "SELECT DISTINCT c FROM br.com.bytebank.banco.modelo.encapsulado.Conta c LEFT JOIN FETCH c.movimentacoes";
		
		List<Conta> contas = em.createQuery(jpql, Conta.class)
				.getResultList();
		
		System.out.println(contas.size());
		
		contas.forEach(c ->{ 
			System.out.println("Titular: " + c.getTitular());
			System.out.println("Agencia: "+ c.getAgencia());
			System.out.println("Numero: "+ c.getNumero());
			System.out.println("Movimentacoes: "+ c.getMovimentacoes());
		});
	}
}
