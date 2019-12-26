package io.altar.jseproject.states;

public class ViewProducts extends State {

	@Override
	public int run() {
		
		System.out.println("Id dos produtos "+productBusiness.getAllIds());
		
		//descricao dos produtos??
		System.out.println(productBusiness.consultar());
		
		
		return 1;
	}

}
//TODO identificar em quantas prateleiras esta o produto