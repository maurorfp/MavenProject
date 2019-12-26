package io.altar.jseproject.states;

import io.altar.jseproject.models.Shelf;

public class ShelfEdit extends State {

	@Override
	public int run() {
		long id = sc.getValidLong("Qual o id da prateleira", shelfBusiness.getAllIds());
		Shelf shelf = shelfBusiness.consultarId(id);
		System.out.println("Editar prateleira:");
		int capacity = sc.getInt("Edita a capacidade da prateleira");
		float dailyPrice = sc.getFloat("Edita o preco diario da prateleira");
		shelf.setCapacity(capacity);
		shelf.setDailyPrice(dailyPrice);
		shelfBusiness.editId(shelf);
		System.out.println("Prateleira editada");
		
		return 1;
	}

}
