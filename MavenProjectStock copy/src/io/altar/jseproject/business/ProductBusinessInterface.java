package io.altar.jseproject.business;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

//variave que estende o busined generico com referencia a classe Product
public interface ProductBusinessInterface extends BusinessInterface <Product> {
	
	
	public ProductRepository DBP= ProductRepository.getInstance();
	

}
