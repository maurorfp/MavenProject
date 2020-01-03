package io.altar.jseproject.states;

import java.util.Set;

//import java.util.Set;

public class MenuProducts extends State{

	@Override
	public int run() {
		Set<Long> productsIds = productBusiness.getAllIds();
		for (Long id : productsIds) {
			System.out.println("ID produto : " + id);
		}
		int[] options;
		if (productBusiness.isEmpty()) {
			options = new int[] { 1, 5 };
			System.out.println("1)\t Criar Produto");
			System.out.println("5)\t Voltar");
		} else {
			options = new int[] { 1, 2, 3, 4, 5 };
			System.out.println("1)\t Criar Produto");
			System.out.println("2)\t Editar produto");
			System.out.println("3)\t Consultar produto");
			System.out.println("4)\t Remover produto");
			System.out.println("5)\t Voltar");
		}
		
		return sc.getValidInt("Selecionar opcao: ", options);
	}
	

}
//private void ecraLProducts() {
//	int option = 0;
//	do {
//		Set<Long> productsIds = DBP.getAllIds();
//		for (Long id : productsIds) {
//			System.out.println("ID produto : " + id);
//		}
//		int[] options;
//		if (DBP.isEmpty()) {
//			options = new int[] { 1, 5 };
//			System.out.println("1)\t Criar Produto");
//			System.out.println("5)\t Voltar");
//		} else {
//			options = new int[] { 1, 2, 3, 4, 5 };
//			System.out.println("1)\t Criar Produto");
//			System.out.println("2)\t Editar produto");
//			System.out.println("3)\t Consultar produto");
//			System.out.println("4)\t Remover produto");
//			System.out.println("5)\t Voltar");
//		}
//		option = sc.getValidInt("Selecionar opcao : ", options);
//		switch (option) {
//			case 1:
//				//criar produto
//				createProduct();
//				break;
//			case 2:
//				//editar produto
//				editProduct();
//				break;
//			case 3:
//				//consultar produto
//				viewProduct();
//				break;
//			case 4:
//				//remover produto
//				deleteProduct();
//				break;
//			}
//	} while (option != 5);
//}