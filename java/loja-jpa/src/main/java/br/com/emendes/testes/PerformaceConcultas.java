package br.com.emendes.testes;

import javax.persistence.EntityManager;

import br.com.emendes.dao.PedidoDao;
import br.com.emendes.modelo.Pedido;
import br.com.emendes.util.JPAUtil;

public class PerformaceConcultas {

	public static void main(String[] args) {
		CadastroDePedido.popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido1 = pedidoDao.buscarPedidoComCliente(1l);
		em.close();
		System.out.println(pedido1.getCliente().getNome());
	}

}
