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
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

@Path("shelfs")
public class ShelfControler {
	
//forma de chamar os metodos associados ao product business
	ShelfBusiness shelfBusiness = new ShelfBusiness();
	
	@Context
	protected UriInfo context;
	
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)

	// este pedaco liga ao servidor aplicacional
	public String status() {
		return "Url :" + context.getRequestUri().toString() + " is ok";
	}
	
	//criar a shelf//
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public Shelf create(Shelf shelf) {
		shelfBusiness.create(shelf);
		return shelf;
	}
	
	//consultar os ids das shelf
	@GET
	@Path("/allIds")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public Set<Long>  read() {
		return shelfBusiness.getAllIds();
	}
	
	//editar a prateleira
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf update(@PathParam("id")Long id, Shelf shelf) {
		shelfBusiness.editId(shelf);
		return shelf;
	}
	
	// eliminar a prateleira
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		shelfBusiness.delete(id);
	}
	
	//consultar
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection <Shelf>  consultar() {
		return shelfBusiness.consultar();
	}
}
