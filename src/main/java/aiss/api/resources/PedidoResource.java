package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.LineaPedido;
import aiss.model.Pedido;
import aiss.model.repository.MapPedidoRepository;
import aiss.model.repository.PedidoRepository;


@Path("/pedidos")
public class PedidoResource {
	
	/* Singleton */
	private static PedidoResource _instance=null;
	PedidoRepository repository;
	
	private PedidoResource() {
		repository=MapPedidoRepository.getInstance();

	}
	
	public static PedidoResource getInstance()
	{
		if(_instance==null)
				_instance=new PedidoResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Pedido> getAll(@QueryParam("isEmpty") Boolean isEmpty)
	{
		List<Pedido> result = new ArrayList<Pedido>();
		for(Pedido pedido: repository.getAllPedidos()) {
			if(isEmpty == null //Empty playlist filter
					|| (isEmpty && (pedido.getLineasPedido() == null || pedido.getLineasPedido().size() == 0))
					|| (!isEmpty && (pedido.getLineasPedido() != null && pedido.getLineasPedido().size() > 0))){
				result.add(pedido);
			}
		}
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pedido get(@PathParam("id") String id)
	{
		Pedido list = repository.getPedido(id);
		
		if (list == null) {
			throw new NotFoundException("El pedido con id="+ id +" no fue encontrado.");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPedido(@Context UriInfo uriInfo, Pedido pedido) {
		if (pedido.getId() == null || "".equals(pedido.getId()))
			throw new BadRequestException("La id del pedido no puede estar vacía");
		
		repository.addPedido(pedido);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(pedido.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(pedido);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updatePedido(Pedido pedido) {
		Pedido pedidoantiguo = repository.getPedido(pedido.getId());
		if (pedidoantiguo == null) {
			throw new NotFoundException("El pedido con id="+ pedido.getId() +" no fue encontrado");			
		}
		
//		if (pedido.getLineasPedido()!=null)
//			throw new BadRequestException("");
		
		// Update id
		if (pedido.getId()!=null)
			pedidoantiguo.setId(pedido.getId());
		
		//Update nombreCliente
		if (pedido.getNombreCliente()!=null)
			pedidoantiguo.setNombreCliente(pedido.getNombreCliente());
		
		//Update precioTotal
		if(pedido.getPrecioPedido()!=null)
			pedidoantiguo.setPrecioPedido(pedido.getPrecioPedido());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePedido(@PathParam("id") String id) {
		Pedido toberemoved=repository.getPedido(id);
		if (toberemoved == null)
			throw new NotFoundException("El pedido con id="+ id +" no fue encontrado");
		else
			repository.deletePedido(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{pedidoId}/{lineaPedidoId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addLineaPedido(@Context UriInfo uriInfo,@PathParam("pedidoId") String pedidoId, @PathParam("lineaPedidoId") String lineaPedidoId)
	{				
		
		Pedido pedido = repository.getPedido(pedidoId);
		LineaPedido lineaPedido = repository.getLineaPedido(lineaPedidoId);
		
		if (pedido==null)
			throw new NotFoundException("El pedido con id=" + pedidoId + " no fue encontrado");
		
		if (lineaPedido == null)
			throw new NotFoundException("La linea de pedido con id=" + lineaPedidoId + " no fue encontrada");
		
		if (pedido.getLineaPedido(lineaPedidoId)!=null)
			throw new BadRequestException("Ya está incluido.");
			
		repository.addLineaPedido(pedidoId, lineaPedidoId);

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(pedidoId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(pedido);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{pedidoId}/{lineaPedidoId}")
	public Response removeLineaPedido(@PathParam("pedidoId") String pedidoId, @PathParam("lineaPedidoId") String lineaPedidoId) {
		Pedido pedido = repository.getPedido(pedidoId);
		LineaPedido lineaPedido = repository.getLineaPedido(lineaPedidoId);
		
		if (pedido==null)
			throw new NotFoundException("TEl pedido con id=" + pedidoId + " no fue encontrado");
		
		if (lineaPedido == null)
			throw new NotFoundException("TLa linea de pedido con id=" + lineaPedidoId + " no fue encontrada");
		
		
		repository.removeLineaPedido(pedidoId, lineaPedidoId);		
		
		return Response.noContent().build();
	}
}