package br.com.ldnovaes.dao;

import br.com.ldnovaes.model.Persistente;
import jakarta.persistence.EntityManager;

public class GenericDAO<T extends Persistente> implements IGenericDAO<T>{
	
	private EntityManager em;
	
	private Class<T> tipoModel;

    public GenericDAO(EntityManager em, Class<T> tipoModel) {
        this.em = em;
        this.tipoModel = tipoModel;
    }

	@Override
	public void persistir(T model) {
		this.em.getTransaction().begin();
		this.em.persist(model);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	@Override
	public void deletar(T model) {
		this.em.getTransaction().begin();
		this.em.remove(model);;
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	@Override
	public T buscarPorId(Long id) {
		this.em.getTransaction().begin();
		T model = this.em.find(this.tipoModel, id);
		this.em.getTransaction().commit();
		return model;
	}

}
