package br.com.emendes.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.emendes.dao.CategoriaDao;
import br.com.emendes.dao.ClienteDao;
import br.com.emendes.dao.PedidoDao;
import br.com.emendes.dao.ProdutoDao;
import br.com.emendes.modelo.Categoria;
import br.com.emendes.modelo.Cliente;
import br.com.emendes.modelo.ItemPedido;
import br.com.emendes.modelo.Pedido;
import br.com.emendes.modelo.Produto;
import br.com.emendes.util.JPAUtil;
import br.com.emendes.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
//		Categoria celulares = new Categoria("Celulares");
//		Categoria videogames = new Categoria("Videogames");
//		Categoria informatica = new Categoria("Informatica");
//		
//		Produto mia2 = new Produto("Xiomi MI A2", "Celular Bão", new BigDecimal("850.99"), celulares);
//		Produto redmi = new Produto("Xiomi Redmi", "Celular MUITO Bão", new BigDecimal("970.85"), celulares);
//		Produto mouse = new Produto("Mouse Dell", "Mouse wireless", new BigDecimal("45.20"), informatica);
//		Produto headphone = new Produto("Headphone JBL", "Headphone JBL Bluetooth", new BigDecimal("260.50"), informatica);
//		Produto playstation = new Produto("PlayStation 5", "Sony PlayStation 5", new BigDecimal("4500.00"), videogames);
//		Produto nintendo = new Produto("Nintendo Switch", "Videogame portatil Nintendo Switch", new BigDecimal("2300.00"), videogames);
//		
//		Cliente mei = new Cliente("Mei", "123456");
//		Cliente kira = new Cliente("Kira", "654321");
//		
//		cadastrarCategoria(celulares);
//		cadastrarCategoria(videogames);
//		cadastrarCategoria(informatica);
//		
//		cadastrarProduto(mia2);
//		cadastrarProduto(redmi);
//		cadastrarProduto(mouse);
//		cadastrarProduto(headphone);
//		cadastrarProduto(playstation);
//		cadastrarProduto(nintendo);
//		
//		cadastrarCliente(mei);
//		cadastrarCliente(kira);
////		----------------------------------------------
		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao produtoDao = new ProdutoDao(em);
//		ClienteDao clienteDao = new ClienteDao(em);
//		em.getTransaction().begin();
//		
//		Pedido pedido1 = new Pedido(clienteDao.buscarPorId(1l));
//		pedido1.adicionarItem(new ItemPedido(3, produtoDao.buscarPorId(1l), pedido1));
//		pedido1.adicionarItem(new ItemPedido(5, produtoDao.buscarPorId(1l), pedido1));
//		pedido1.adicionarItem(new ItemPedido(5, produtoDao.buscarPorId(4l), pedido1));
//		
//		Pedido pedido2 = new Pedido(clienteDao.buscarPorId(1l));
//		pedido2.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(4l), pedido2));
//		pedido2.adicionarItem(new ItemPedido(6, produtoDao.buscarPorId(6l), pedido2));
//		pedido2.adicionarItem(new ItemPedido(3, produtoDao.buscarPorId(1l), pedido2));
//		
//		Pedido pedido3 = new Pedido(clienteDao.buscarPorId(3l));
//		pedido3.adicionarItem(new ItemPedido(8, produtoDao.buscarPorId(5l), pedido3));
//		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(3l), pedido3));
//		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(4l), pedido3));
//		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(1l), pedido3));
//		
		PedidoDao pedidoDao = new PedidoDao(em);
//		pedidoDao.cadastrar(pedido1);
//		pedidoDao.cadastrar(pedido2);
//		pedidoDao.cadastrar(pedido3);
//			
//		em.getTransaction().commit();
//		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
//		System.out.println("VALOR TOTAL: "+totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		System.out.println("--------------------------------------------------------------------------------------");
		relatorio.forEach(ob -> {
			System.out.println(ob);
			System.out.println("--------------------------------------------------------------------------------------");
		});

	}

	private static void cadastrarCategoria(Categoria categoria) {

		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(categoria);

		em.getTransaction().commit();
		em.close();
	}

	private static void cadastrarProduto(Produto produto) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();

		produtoDao.cadastrar(produto);

		em.getTransaction().commit();
		em.close();
	}
	
	private static void cadastrarCliente(Cliente cliente) {
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void popularBancoDeDados() {
		Categoria celulares = new Categoria("Celulares");
		Categoria videogames = new Categoria("Videogames");
		Categoria informatica = new Categoria("Informatica");
		
		Produto mia2 = new Produto("Xiomi MI A2", "Celular Bão", new BigDecimal("850.99"), celulares);
		Produto redmi = new Produto("Xiomi Redmi", "Celular MUITO Bão", new BigDecimal("970.85"), celulares);
		Produto mouse = new Produto("Mouse Dell", "Mouse wireless", new BigDecimal("45.20"), informatica);
		Produto headphone = new Produto("Headphone JBL", "Headphone JBL Bluetooth", new BigDecimal("260.50"), informatica);
		Produto playstation = new Produto("PlayStation 5", "Sony PlayStation 5", new BigDecimal("4500.00"), videogames);
		Produto nintendo = new Produto("Nintendo Switch", "Videogame portatil Nintendo Switch", new BigDecimal("2300.00"), videogames);
		
		Cliente mei = new Cliente("Mei", "123456");
		Cliente kira = new Cliente("Kira", "654321");
		
		cadastrarCategoria(celulares);
		cadastrarCategoria(videogames);
		cadastrarCategoria(informatica);
		
		cadastrarProduto(mia2);
		cadastrarProduto(redmi);
		cadastrarProduto(mouse);
		cadastrarProduto(headphone);
		cadastrarProduto(playstation);
		cadastrarProduto(nintendo);
		
		cadastrarCliente(mei);
		cadastrarCliente(kira);
//		----------------------------------------------
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		em.getTransaction().begin();
		
		Pedido pedido1 = new Pedido(clienteDao.buscarPorId(1l));
		pedido1.adicionarItem(new ItemPedido(3, produtoDao.buscarPorId(1l), pedido1));
		pedido1.adicionarItem(new ItemPedido(5, produtoDao.buscarPorId(1l), pedido1));
		pedido1.adicionarItem(new ItemPedido(5, produtoDao.buscarPorId(4l), pedido1));
		
		Pedido pedido2 = new Pedido(clienteDao.buscarPorId(1l));
		pedido2.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(4l), pedido2));
		pedido2.adicionarItem(new ItemPedido(6, produtoDao.buscarPorId(6l), pedido2));
		pedido2.adicionarItem(new ItemPedido(3, produtoDao.buscarPorId(1l), pedido2));
		
		Pedido pedido3 = new Pedido(clienteDao.buscarPorId(3l));
		pedido3.adicionarItem(new ItemPedido(8, produtoDao.buscarPorId(5l), pedido3));
		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(3l), pedido3));
		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(4l), pedido3));
		pedido3.adicionarItem(new ItemPedido(2, produtoDao.buscarPorId(1l), pedido3));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido1);
		pedidoDao.cadastrar(pedido2);
		pedidoDao.cadastrar(pedido3);
			
		em.getTransaction().commit();
	}
}
