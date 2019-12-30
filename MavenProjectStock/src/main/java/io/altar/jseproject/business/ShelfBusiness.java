package io.altar.jseproject.business;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfBusiness implements ShelfBusinessInterface{
	public ShelfRepository DBS = ShelfRepository.getInstance();

	@Override
	public void create(Shelf t) {
		DBS.create(t);
		
	}

	@Override
	public Collection<Shelf> consultar() {
		return DBS.consultar();
	}

	@Override
	public Shelf consultarId(Long id) {
		return DBS.consultarId(id);
		
	}

	@Override
	public void editId(Shelf entity) {
	DBS.editId(entity);
		
	}

	@Override
	public void delete(Long id) {
		Shelf shelfToRemove = DBS.consultarId(id);
		if(shelfToRemove.getProductId()!=0) {
			ProductBusiness.updateShelfOnProduct(shelfToRemove.getProductId(),id); /// erro??
		}
		DBS.delete(id);
		
	}

	@Override
	public boolean isEmpty() {
		return DBS.isEmpty();
		
	}

	@Override
	public Set<Long> getAllIds() {
		
		return DBS.getAllIds();
	}

	//funcao para fazer o update das shelfs e verificar se existe prateleiras para  colocar o produtos
	public void updateProductOnShelfs(Long productId, List<Long> shelfsOld, List<Long> shelfsNew) {
	for (Long shelfId: shelfsOld) { // for each para o Long shelf Id dentro do array de shelfs old
		Shelf shelf = DBS.consultarId(shelfId);
		if (shelfsNew.indexOf(shelfId)==-1) {
			shelf.setProductId((long)0);
			DBS.editId(shelf);
		}
	}
	for (Long shelfId: shelfsNew) {
		Shelf shelf = DBS.consultarId(shelfId);
		if (shelfsOld.indexOf(shelfId)==-1) {
			shelf.setProductId(productId);
			DBS.editId(shelf);
		}
	}
	
	//nao sei o que acontece aqui?? Deduzo que obete uma lista de IDs de prateleiras de producto selecionado
	}	
	public List<Long> getShelfIdsByProductId(long productId) {
		Collection<Shelf> values = DBS.consultar();
		List<Long> result = values.stream()
		.filter(value -> value.getProductId() == productId)
		.map(value -> value.getId())
		.collect(Collectors.toList());

		return result;
	}
}
