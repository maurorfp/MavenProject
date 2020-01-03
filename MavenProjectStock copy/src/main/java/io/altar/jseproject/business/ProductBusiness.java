package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness implements ProductBusinessInterface{
	public ProductRepository DBP= ProductRepository.getInstance();
	static final ShelfBusiness SB = new ShelfBusiness();
	
	
	//estes orverrides
	@Override
	public long create(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Collection<Product> consultar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Product consultarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void editId(Product entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Set<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public long create(Product product) {
////// validar os valores de IVA (6,13,23), validar o desconto (0-100)//
////		if (product.getIva()!= 6 && product.getIva()!= 13 && product.getIva()!= 23) {
////		
////			throw new RuntimeException("insira um IVA valido");
////		}
////		
////		if (product.getDiscount()>1 && product.getDiscount()<100) {
////			
////			throw new RuntimeException("insira um valor de desconto entre 1 e  100");
////			
////		}
////		long currentId = DBP.create(product);
////		if(product.getShelvesIds().size()>0) {
////			SB.updateProductOnShelfs(currentId, new ArrayList<Long>(),product.getShelvesIds());
////		}
////		return currentId;
//		return product;
//		
//	}
//
//	@Override
//	public Collection<Product> consultar() {
//		
//		return DBP.consultar();
//	}
//
//	@Override
//	public Product consultarId(Long id) {
//		
//		return DBP.consultarId(id);
//	}
//
//	
//	@Override
//	public void editId(Product product) {
//		Product oldProduct = DBP.consultarId(product.getId());
//		if(!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
//			SB.updateProductOnShelfs(product.getId(),oldProduct.getShelvesIds(),product.getShelvesIds());
//		}
//		DBP.editId(product);
//		
//	}
//	
//	@Override
//// validar o Id inserido para deletar -  enviar exception mensage de id errado.
//	public void delete(Long id) {
//		Product product= DBP.consultarId(id);
//		
//		if (product == null) {
//			
//			throw new RuntimeException("insira um id valido");
//		}
//		
//		DBP.delete(id);
////aqui e que vai ficar o delete dos ids dos produtos nas shelfs onde estao. AINDA FALTA FAZER??//		
//		SB.updateProductOnShelfs(product.getId(),product.getShelvesIds(),new ArrayList<Long>());
//	}
//
//	@Override
//	public boolean isEmpty() {
//		
//		return DBP.isEmpty();
//	}
//
//
//	@Override
//	public Set<Long> getAllIds() {
//		
//		return DBP.getAllIds();
//	}
//	
//// actualizar os IDs das prateleiras nos produtos
//	public void updateShelfOnProduct(long productId, long shelfId) {
//		Product product = DBP.consultarId(productId);
//		product.getShelvesIds().remove(shelfId);
//		DBP.editId(product);
//	}
//	
//	public List<Long> getShelfIdsByProductId(long productId) {
//
//		return SB.getShelfIdsByProductId(productId);
	
}
//caminho directo para o Git do Joao
//https://github.com/Joaoscortes/upacademyJavaStarterExamples/commit/23d098c5e0466d8ade0f9fa30e6389a3372b6283