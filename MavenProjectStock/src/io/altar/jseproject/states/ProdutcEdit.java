package io.altar.jseproject.states;

import io.altar.jseproject.models.Product;

public class ProdutcEdit extends State {

	@Override
	public int run() {
		long id = sc.getValidLong("Qual o id do produto a editar?", productBusiness.getAllIds());
		Product product1 = productBusiness.consultarId(id);
		System.out.println("Editar produto:");
		int discount = sc.getInt("Edite o desconto associado ao produto. Desconto anterior: " + product1.getDiscount());
		int[] options = {6, 13, 23};
		int iva = sc.getValidIvas("Edite o valor do IVA (6%,13% ou 23%). Valor anterior: " + product1.getIva(), options);
		float pvp = sc.getFloat("Edite o PVP. PVP anterior: "+ product1.getPvp());
		product1.setDiscount(discount);
		product1.setIva(iva);
		product1.setPvp(pvp);
		productBusiness.editId(product1);
		System.out.println("Produto editado!");
		System.out.println("");
		
		return 1;

	}

}
//TODO editar os produtos em todas as prateleiras onde existe o produto

//TODO editar tambem prateleira onde esta o produto