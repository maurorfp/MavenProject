package io.altar.jseproject.states;

import io.altar.jseproject.models.Product;

public class ProductDelete extends State {

	@Override
	public int run() {
		System.out.println("Remover produto");
		long productId = sc.getValidLong("Introduzir ID do produto que quer remover : ", productBusiness.getAllIds());
		productBusiness.delete(productId);
		System.out.println("Produto eliminado!");
		System.out.println("");
//		productId.setShelvesIds(0);
		
//no git do Joao ele nao tem o set das prateleiras??
		return 1;
	}
	
}
//TODO remover o produto de todas as prateleiras - na verdade e colocar a 0, os ids das prateleiras