package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness implements ProductBusinessInterface{
	public ProductRepository DBP= ProductRepository.getInstance();
	
	
	@Override
	
	//esta definido como VOID nao permite ter return! Tenho que implementar o EntitiyBusiness e EntiteyBusiness interfacce??
	public void create(Product product) {
		long currentId = DBP.create(product);
		if(product.getShelvesIds().size()>0) {
			ShelfBusiness.updateProductOnShelfs(currentId, new ArrayList<Long>(),product.getShelvesIds());
		}
		return currentId;
		
	}

	@Override
	public Collection<Product> consultar() {
		
		return DBP.consultar();
	}

	@Override
	public Product consultarId(Long id) {
		
		return DBP.consultarId(id);
	}

	
	//continuo com o mesmo erro do static?? - tenho que implementar o EntityBusiness
	@Override
	public void editId(Product product) {
		Product oldProduct = DBP.consultarId(product.getId());
		if(!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
			ShelfBusiness.updateProductOnShelfs(product.getId(),oldProduct.getShelvesIds(),product.getShelvesIds());
		}
		DBP.editId(product);
		
	}
	//mesmo problema do static
	@Override
	public void delete(Long id) {
		Product product= DBP.consultarId(id);
		DBP.delete(id);
//aqui e que vai ficar o delete dos ids dos produtos nas shelfs onde estao. AINDA FALTA FAZER??//		
		ShelfBusiness.updateProductOnShelfs(product.getId(),product.getShelvesIds(),new ArrayList<Long>());
	}

	@Override
	public boolean isEmpty() {
		
		return DBP.isEmpty();
	}


	@Override
	public Set<Long> getAllIds() {
		
		return DBP.getAllIds();
	}
	
// actualizar os IDs das prateleiras nos produtos
	public void updateShelfOnProduct(long productId, long shelfId) {
		Product product = DBP.consultarId(productId);
		product.getShelvesIds().remove(shelfId);
		DBP.editId(product);
	}
	
	public List<Long> getShelfIdsByProductId(long productId) {

		return ShelfBusiness.getShelfIdsByProductId(productId);
	}
}
