package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class PerformanceConsultas {

	public static void main(String[] args) {
		JPAUtil.popularBD();
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(1L);
		em.close();
		System.out.println(pedido.getCliente().getNome());
	}
}
