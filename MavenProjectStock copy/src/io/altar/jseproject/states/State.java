package io.altar.jseproject.states;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;

public abstract class  State {
	
	public static final ScannerUtils sc = new ScannerUtils();
	
	//era private mudei para public porque a classe ProductAdd nao conseguia aceder ??
	public ProductBusiness productBusiness= new ProductBusiness();
	public ShelfBusiness shelfBusiness = new ShelfBusiness();

	public abstract int run();

}
