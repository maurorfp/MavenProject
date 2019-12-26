package io.altar.jseproject.business;

import java.util.Collection;
import java.util.Set;

import io.altar.jseproject.models.Entity;

public abstract interface  BusinessInterface<T extends Entity> {
	
//metodos genericos a implementar provenientes do entity e genericas em todas as classes// - e um interface so define a regas que as classe que extende devem implementar

	void create (T t);

	//consultar sem criterio o tipo objecto - nao leva parametros de entrada porque queremos todos	
	Collection<T> consultar();
	
	//consultar por Id - o metodo .get vai buscr os elementos do objecto
	public T consultarId(Long id);
		
	// editar os elementos por Id
	public void editId(T entity);
	
	//eliminar as variaveis
	public void delete(Long id);
	
	//verificacao se nao existe Ids
	public boolean isEmpty();
	
	//pedir todos os elementos da DB
	Set<Long> getAllIds();

}
