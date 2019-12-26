package io.altar.jseproject.controlers;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.models.Product;

@Path("products")
public class ProductControler {

	//forma de chamar os metodos associados ao product business
	ProductBusiness productBusiness = new ProductBusiness();

	@Context
	protected UriInfo context;

	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)

	// este pedaco liga ao servidor aplicacional
	public String status() {
		return "Url :" + context.getRequestUri().toString() + " is ok";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public Product create(Product product) {
		productBusiness.create(product);
		return product;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public Set<Long>  read() {
		return productBusiness.getAllIds();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Product product) {
		productBusiness.editId(product);
	}
	
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		productBusiness.delete(id);
	}

}
