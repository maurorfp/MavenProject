package io.altar.jseproject.textinterface;

import java.util.Set;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();
	private ProductRepository DBP= ProductRepository.getInstance();
	private ShelfRepository DBS = ShelfRepository.getInstance();
	
	
	public void ecraInicio() {
		int option = 0;
		do {
			System.out.println("1)\t Listar Produtos");
			System.out.println("2)\t Listar Prateleira");
			System.out.println("3)\t Sair");
			int[] options = { 1, 2, 3 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				ecraLProducts();
				break;
			case 2:
				ecraLShelves();
				break;
			case 3:
				System.out.println("Sai da aplicacao");
				break;
			}
		} while (option != 3);
	}

	private void ecraLShelves() {
		int option = 0;
		do {
			
			Set<Long> shelfsIds = DBS.getAllIds();
			for (Long id : shelfsIds) {
				System.out.println("ID da prateleira : " + id);
			}
			int[] options;
			if (DBS.isEmpty()) {
				options = new int[] { 1, 5 };
				System.out.println("1)\t Criar Prateleira");
				System.out.println("5)\t Voltar");
			} else {
				options = new int[] { 1, 2, 3, 4, 5 };
				System.out.println("1)\t Criar Prateleira");
				System.out.println("2)\t Editar Prateleira");
				System.out.println("3)\t Consultar Prateleira");
				System.out.println("4)\t Remover Prateleira");
				System.out.println("5)\t Voltar");
			}
	
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				//criar prateleira
				ecraNewShelf();
				break;
			case 2:
				//editar prateleira
				editShefl();
				break;
			case 3:
				//consultar prateleira
				viewShefl();
				break;
			case 4:
				//remover prateleira
				ecraDeleteShelf();
				break;
			}
		} while (option != 5);
	}


	private void ecraLProducts() {
		int option = 0;
		do {
			Set<Long> productsIds = DBP.getAllIds();
			for (Long id : productsIds) {
				System.out.println("ID produto : " + id);
			}
			int[] options;
			if (DBP.isEmpty()) {
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
			option = sc.getValidInt("Selecionar opcao : ", options);
			switch (option) {
				case 1:
					//criar produto
					createProduct();
					break;
				case 2:
					//editar produto
					editProduct();
					break;
				case 3:
					//consultar produto
					viewProduct();
					break;
				case 4:
					//remover produto
					deleteProduct();
					break;
				}
		} while (option != 5);
	}
	
	


//logica oara a criacao de uma nova prateleira
	private void ecraNewShelf() {
		System.out.println("Criar prateleira:");
		int capacity = sc.getInt("Mete a capacidade");
		float dailyPrice = sc.getFloat("Mete o preco diario");
		Shelf shelf = new Shelf(capacity, dailyPrice);
		DBS.create(shelf);
	}
	
	
// logica eliminar prateleira////
	private void ecraDeleteShelf() {
		System.out.println("Remover prateleira");
		long shelfId = sc.getValidLong("Introduzir ID da prateleira que quer remover : ", DBS.getAllIds());
		DBS.delete(shelfId);
		System.out.println("Prateleira removida");
		
//TODO editar os produtos (products Id) da prateleira eliminada?
		
	}
//logica para editar prateleira///////
	private void editShefl() {
		long id = sc.getValidLong("Qual o id da prateleira", DBS.getAllIds());
		Shelf shelf = DBS.consultarId(id);
		System.out.println("Editar prateleira:");
		int capacity = sc.getInt("Edita a capacidade");
		float dailyPrice = sc.getFloat("Edita o preco diario");
		shelf.setCapacity(capacity);
		shelf.setDailyPrice(dailyPrice);
		DBS.editId(shelf);
		

		
	
		
	}
	
//logica para consulta prateleiras///////
	private void viewShefl() {
		int [] countIDs =  ;// variavel com o arrya de produts ids
		System.out.println("Id das prateleiras" + DBS.getAllIds());
		
		//TODO introduzir info count produts - nao funciona
		System.out.println("Quantidade de produtos" + productsIds.lenght);


		
	}
	
//logica para a criacao de produts/////
	private void createProduct() {
		System.out.println("Criar produto:");
		int discount = sc.getInt("Indique o desconto associado ao produto");
		int[] options = {6, 13, 23};
		int iva = sc.getValidIvas("Coloque o valor do IVA (6%,13% ou 23%", options);
		float pvp = sc.getFloat("Coloque o PVP");
		Product product1 = new Product(discount, iva,pvp);
		DBP.create(product1);
		System.out.println("Produto criado");

	}
	
//logica para a edicao de produts/////
	private void editProduct(){
		long id = sc.getValidLong("Qual o id do produto a editar", DBP.getAllIds());
		Product product1 = DBP.consultarId(id);
		System.out.println("Editar produto:");
		int discount = sc.getInt("Edite o desconto associado ao produto");
		int[] options = {6, 13, 23};
		int iva = sc.getValidIvas("Coloque o valor do IVA (6%,13% ou 23%", options);
		float pvp = sc.getFloat("Edite o PVP");
		product1.setDiscount(discount);
		product1.setIva(iva);
		product1.setPvp(pvp);
		DBP.editId(product1);
		System.out.println("Produto editado");
		
//TODO editar os produtos em todas as prateleiras onde existe o produto
		
//TODO editar tambem prateleira onde esta o produto
	}

//logica para consulta produtos ///////
		private void viewProduct() {
			System.out.println("Id dos produtos "+DBP.getAllIds());
			//descricao do produto??
			System.out.println(DBP);
			
//TODO identificar em quantas prateleiras esta o produto
		}
		
///logica para eliminar produts
		private void deleteProduct() {
			System.out.println("Remover produto");
			long productId = sc.getValidLong("Introduzir ID do produt que quer remover : ", DBP.getAllIds());
			DBP.delete(productId);
			System.out.println("Produto removido");
			
//TODO remover o produto de todas as prateleiras
//ainda nao funciona
			
			Set<Long> productsIds = DBP.getAllIds();
			for (Long id : productsIds) {}
		}
}

