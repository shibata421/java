package br.com.alura.loja.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	public static void popularBD() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto ps5 = new Produto("PlayStation 5", "Video Game da Sony", new BigDecimal("5000"), videogames);
		Produto macbook = new Produto("MacBook Pro", "Computador da Apple", new BigDecimal("10000"), informatica);

		Cliente cliente = new Cliente("Rodrigo", "123456");

		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);

		Pedido pedido1 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(pedido1, celular, 10));
		pedido1.adicionarItem(new ItemPedido(pedido1, ps5, 40));

		Pedido pedido2 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(pedido2, macbook, 2));
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(ps5);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido1);
		
		em.getTransaction().commit();
		em.close();
	}
}
