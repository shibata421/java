package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.CategoriaId;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		JPAUtil.popularBD();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto produto = produtoDao.buscarPorId(1L);
		System.out.println("---------------------------");
		System.out.println("O pre�o do produto � " + produto.getPreco());
		System.out.println("---------------------------");
		
		produtoDao.buscarPorNomeDaCategoria("celulares")
			.forEach(p -> {
				System.out.println("---------------------------");
				System.out.println("O nome do produto � " + p.getNome());	
				System.out.println("O categorida do produto � " + p.getCategoria().getNome());	
				System.out.println("---------------------------");
			});
		
		BigDecimal preco = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		System.out.println("---------------------------");
		System.out.println("O pre�o do produto � " + preco);
		System.out.println("---------------------------");
		
		em.find(Categoria.class, new CategoriaId("CELULARES", "xpto"));
	}
}
