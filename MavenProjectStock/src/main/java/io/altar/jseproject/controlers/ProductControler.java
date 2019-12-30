package io.altar.jseproject.controlers;

import java.util.Collection;
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
import javax.ws.rs.core.Response;
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
// o resultado do post
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Collection <Product>  read() {
		return productBusiness.consultar();
	}
	
	//ver o produto por Id
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Product readIds(@PathParam("id") Long id) {
		return productBusiness.consultarId(id);
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product update(@PathParam("id")Long id, Product product) {
		productBusiness.editId(product);
		return product;
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		try{ 
			productBusiness.delete(id);
			return Response.ok().build();
		}
		
		catch (RuntimeException e) {
			return Response.status(400).entity(e.getMessage()).build(); 
		}
		
		
	
	
	
		
		
	}
	
	
}
