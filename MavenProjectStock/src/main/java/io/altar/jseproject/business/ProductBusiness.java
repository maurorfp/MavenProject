package io.altar.jseproject.business;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness implements ProductBusinessInterface{
	public ProductRepository DBP= ProductRepository.getInstance();
	
	
	@Override
	public void create(Product t) {
		DBP.create(t);
		
	}

	@Override
	public Collection<Product> consultar() {
		
		return DBP.consultar();
	}

	@Override
	public Product consultarId(Long id) {
		
		return DBP.consultarId(id);
	}

	@Override
	public void editId(Product entity) {
		DBP.editId(entity);
		
	}

	@Override
	public void delete(Long id) {
//		Product p= consultarId(id);
//		List<Long> ids = p.getShelvesIds();
		DBP.delete(id);
//aqui e que vai ficar o delete dos ids dos produtos nas shelfs onde estao. AINDA FALTA FAZER??//		
		
	}

	@Override
	public boolean isEmpty() {
		
		return DBP.isEmpty();
	}


	@Override
	public Set<Long> getAllIds() {
		
		return DBP.getAllIds();
	}

}
