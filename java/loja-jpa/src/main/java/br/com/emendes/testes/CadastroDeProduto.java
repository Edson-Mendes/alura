package br.com.emendes.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.emendes.dao.CategoriaDao;
import br.com.emendes.dao.ProdutoDao;
import br.com.emendes.modelo.Categoria;
import br.com.emendes.modelo.Produto;
import br.com.emendes.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Categoria categoria = new Categoria("Celulares");
		Produto produto1 = new Produto("Xiomi MI A2", "Celular Bão", new BigDecimal("850.99"), categoria);
		Produto produto2 = new Produto("Xiomi Redmi", "Celular MUITO Bão", new BigDecimal("970.85"), categoria);

		cadastrarCategoria(categoria);
		cadastrarProduto(produto1);
		cadastrarProduto(produto2);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto outro1 = produtoDao.buscarPorId(1l);
		System.out.println(outro1.getId() + " - " + outro1.getNome() + " - " + outro1.getPreco());
		updatePrecoDoProdutoPorId(1l, new BigDecimal("700.00"));
		Produto outro2 = produtoDao.buscarPorId(1l);
		System.out.println(outro2.getId() + " - " + outro2.getNome() + " - " + outro2.getPreco());
		
		produtoDao.buscarTodos().forEach(p -> System.out.println(p.getNome()+" - "+p.getPreco()));

	}

	private static void cadastrarProduto(Produto produto) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		produtoDao.cadastrar(produto);

		em.getTransaction().commit();
		em.close();
	}

	private static void cadastrarCategoria(Categoria categoria) {

		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(categoria);

		em.getTransaction().commit();
		em.close();
	}

	private static void updatePrecoDoProdutoPorId(Long id, BigDecimal preco) {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		em.getTransaction().begin();
		Produto produto = produtoDao.buscarPorId(1L);
		System.out.println("Preco antes: "+produto.getPreco());
		produto.setPreco(preco);
		System.out.println("Preco depois: "+produto.getPreco());

		em.getTransaction().commit();
		em.close();
	}
}
