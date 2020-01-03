package io.altar.jseproject.controlers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.BusinessInterface;
import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.models.Entity_;
import io.altar.jseproject.models.Product;

@Path("entity")
public abstract class EntityControler <T extends Entity_>  {
	

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

	public Response create(T entity) {
	//check a validacao dos campos de criacao do produto, neste caso o IVA
		try {
//		productBusiness.create(entity);
		return Response.ok().build();
		
		}
		
		catch (RuntimeException e) {
				return Response.status(400).entity(e.getMessage()).build(); 
		}
		
	}

}
