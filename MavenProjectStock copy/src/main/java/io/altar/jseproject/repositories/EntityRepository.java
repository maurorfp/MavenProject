package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.models.Entity_;

public abstract class EntityRepository <T extends Entity_>  {
	
	@PersistenceContext(unitName = "database")
	protected EntityManager em;
	
	
	public long create(T entity){
		
		return em.merge(entity).getId();
	}
	
	protected abstract Class <T> getEntityClass();
	
	
	protected abstract String getAllEntities();
 	public List<T> getAll();{
 		
 		return em.createNamedQuery(name)
 	}


	
	
//consultar sem criterio o tipo objecto - nao leva parametros de entrada porque queremos todos
	public Collection<T> consultar () {
		return myMap.values();
		
	}
	
//consultar por Id - o metodo .get vai buscr os elementos do objecto
	public T consultarId(Long id) {
		return myMap.get(id);
			
	}
	
// editar os elementos por Id
	public void editId(T entity) {
		myMap.put(entity.getId(), entity);
			
	}
	
//eliminar as variaveis
public void delete(Long id) {
		myMap.remove(id);	

	}
	

//verificacao se nao existe Ids
public boolean isEmpty() {
	return (myMap.size() == 0) ? true : false;
}

//pedir todos os elementos da DB
public Set<Long> getAllIds() {
	return myMap.keySet();
}


}





