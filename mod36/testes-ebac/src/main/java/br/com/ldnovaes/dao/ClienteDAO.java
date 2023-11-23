package br.com.ldnovaes.dao;

import br.com.ldnovaes.model.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

	public ClienteDAO(EntityManager em) {
		super(em, Cliente.class);
	}

}
