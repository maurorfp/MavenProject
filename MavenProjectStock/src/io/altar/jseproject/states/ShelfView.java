package io.altar.jseproject.states;

public class ShelfView extends State{

	@Override
	public int run() {

//		int [] countIDs =  ;// variavel com o arrya de produts ids
		System.out.println("Id das prateleiras existentes:" + shelfBusiness.getAllIds());
		
		System.out.println(shelfBusiness.consultar());
		
		//TODO introduzir info count produts - nao funciona
//		System.out.println("Quantidade de produtos" + productsIds.lenght);


		return 1;
	}

}
