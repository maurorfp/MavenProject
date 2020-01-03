package io.altar.jseproject.states;

public class ShelfDelete extends State {

	@Override
	public int run() {
		System.out.println("Remover prateleira");
		long shelfId = sc.getValidLong("Introduzir ID da prateleira que quer remover : ", shelfBusiness.getAllIds());
		shelfBusiness.delete(shelfId);
		System.out.println("Prateleira removida");
		return 1;
	}

}
//TODO editar os produtos (products Id) da prateleira eliminada?

//atencao ao tipo de resultado que tem ser Long tenhoque for;ar que seja longo