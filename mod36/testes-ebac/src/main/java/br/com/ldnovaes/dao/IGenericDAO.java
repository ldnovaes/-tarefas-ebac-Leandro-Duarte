package br.com.ldnovaes.dao;

import br.com.ldnovaes.model.Persistente;

public interface IGenericDAO<T extends Persistente> {
	void persistir(T model);
	void deletar(T model);
	T buscarPorId(Long id);
}
