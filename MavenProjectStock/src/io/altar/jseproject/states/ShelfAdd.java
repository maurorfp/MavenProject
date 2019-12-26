package io.altar.jseproject.states;

import io.altar.jseproject.models.Shelf;

public class ShelfAdd extends State{

	@Override
	public int run() {
			System.out.println("Criar prateleira:");
			int capacity = sc.getInt("Indique a capacidade da prateleira");
			float dailyPrice = sc.getFloat("Indique o preco diario da prateleira");
			Shelf shelf = new Shelf(capacity, dailyPrice);
			shelfBusiness.create(shelf);
			System.out.println("Prateleira criada");
		
		return 1;
		
	}

}
