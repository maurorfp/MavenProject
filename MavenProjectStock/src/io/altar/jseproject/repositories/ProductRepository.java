package io.altar.jseproject.repositories;

import io.altar.jseproject.models.Product;

//duvida na uilitzacao dos <>??
// esta class cria o singleton - encapsula a criacao unica de elementos deste tipo
public class ProductRepository extends EntityRepository <Product> {
	
//o que significa a palavra final?? - o que estou a fazer aqui?
	private static final ProductRepository INSTANCE= new ProductRepository();
	
	
//o que faz este metodo? - funcao encapsulada que apenas retorna um elemento para BD.
	private ProductRepository() {
		
	}
	
		
	public static  ProductRepository getInstance () {
	
	return INSTANCE;
	
}
}
//todos os metodos e classes usadas sao instanciadas nesta classe