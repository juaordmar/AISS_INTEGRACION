package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import aiss.model.Product;
import aiss.model.repository.MapClientRepository;
import aiss.model.repository.ClientRepository;

import java.util.Collection;



@Path("/songs")
public class ProductResource {

	public static ProductResource _instance=null;
	ClientRepository repository;
	
	private ProductResource(){
		repository=MapClientRepository.getInstance();
	}
	
	public static ProductResource getInstance()
	{
		if(_instance==null)
			_instance=new ProductResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Product> getAll()
	{
		return null;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Product get(@PathParam("id") String songId)
	{
		
		return null;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Product song) {
		return null;
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Product song) {
		return null;
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String songId) {
		return null;
	}
	
}
