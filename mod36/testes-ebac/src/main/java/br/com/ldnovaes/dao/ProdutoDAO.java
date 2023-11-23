package br.com.ldnovaes.dao;

import br.com.ldnovaes.model.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO{

	public ProdutoDAO(EntityManager em) {
		super(em, Produto.class);
	}
}
