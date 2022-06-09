package br.com.alura.jpa.dao;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Conta;

public class ContaDAO {

	private EntityManager em;
	
	public ContaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Conta conta) {
		em.persist(conta);
	}
	
	public Conta buscar(Long id) {
		return em.find(Conta.class, id);
	}
	
	public void alterar(Conta conta) {
		em.merge(conta);
	}
}
