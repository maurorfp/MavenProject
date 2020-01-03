package io.altar.jseproject.business;

import java.util.Set;

import io.altar.jseproject.models.Entity;

public interface EntityBusinessInterface <T extends Entity> {

//Corresponde a minha ckase BusinessInferface //
	T get(Long id);
	
	Set<Long> getAllids();
	
	Long create(T entity);
	
	void update (T entity);
	
	void delete (T entity);
	
	boolean isEmpty();

}
