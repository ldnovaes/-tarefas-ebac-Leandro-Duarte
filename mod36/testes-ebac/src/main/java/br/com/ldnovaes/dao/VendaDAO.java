package br.com.ldnovaes.dao;

import br.com.ldnovaes.model.Venda;
import jakarta.persistence.EntityManager;

public class VendaDAO extends GenericDAO<Venda> implements IVendaDAO{

	public VendaDAO(EntityManager em) {
		super(em, Venda.class);
	}

}
