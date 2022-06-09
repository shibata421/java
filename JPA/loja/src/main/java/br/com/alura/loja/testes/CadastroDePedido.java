package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		JPAUtil.popularBD();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);

		Cliente cliente = clienteDao.buscarPorId(1L);
		Produto produto1 = produtoDao.buscarPorId(1L);
		Produto produto2 = produtoDao.buscarPorId(2L);
		Produto produto3 = produtoDao.buscarPorId(3L);

		Pedido pedido1 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(pedido1, produto1, 10));
		pedido1.adicionarItem(new ItemPedido(pedido1, produto2, 40));

		Pedido pedido2 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(pedido2, produto3, 2));
		
		em.getTransaction().begin();
		pedidoDao.cadastrar(pedido1);
		em.getTransaction().commit();

		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: " + totalVendido);
		
		pedidoDao.criarRelatorio().forEach(System.out::println);
		em.close();
	}
}
