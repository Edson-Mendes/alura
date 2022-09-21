package br.com.emendes.testes;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.emendes.dao.ProdutoDao;
import br.com.emendes.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		CadastroDePedido.popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
	}

}
