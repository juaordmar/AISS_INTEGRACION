package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import aiss.api.resources.comparators.ComparatorPrecioUnitario;
import aiss.api.resources.comparators.ComparatorPrecioUnitarioReversed;
import aiss.api.resources.comparators.ComparatorCantidad;
import aiss.api.resources.comparators.ComparatorCantidadReversed;
import aiss.api.resources.comparators.ComparatorNombreProducto;
import aiss.api.resources.comparators.ComparatorNombreProductoReversed;
import aiss.model.LineaPedido;
import aiss.model.repository.MapPedidoRepository;
import aiss.model.repository.PedidoRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Path("/songs")
public class LineaPedidoResource {

	public static LineaPedidoResource _instance=null;
	PedidoRepository repository;
	
	private LineaPedidoResource(){
		repository=MapPedidoRepository.getInstance();
	}
	
	public static LineaPedidoResource getInstance()
	{
		if(_instance==null)
			_instance=new LineaPedidoResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<LineaPedido> getAll(@QueryParam("order") String order,
			@QueryParam("q") String q, @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset)
	{
		List<LineaPedido> result = new ArrayList<LineaPedido>();
		for(LineaPedido LineaPedido: repository.getAllLineaPedidos()) {
			if((q == null || LineaPedido.getNombreProducto().contains(q) ||
					LineaPedido.getPrecioUnitario()==Integer.parseInt(q)) && (limit == null || result.size()<limit)) {
					result.add(LineaPedido);
				}
			}
		if(order!=null) {
			if(order.equals("precioUnitario")) {
				Collections.sort(result, new ComparatorPrecioUnitario());
			}else if(order.equals("-precioUnitario")) {
				Collections.sort(result, new ComparatorPrecioUnitarioReversed());
			}else if(order.equals("cantidad")) {
				Collections.sort(result, new ComparatorCantidad());
			}else if(order.equals("-cantidad")) {
				Collections.sort(result, new ComparatorCantidadReversed());
			}else if(order.equals("nombreProducto")) {
				Collections.sort(result, new ComparatorNombreProducto());
			}else if(order.equals("-nombreProducto")) {
				Collections.sort(result, new ComparatorNombreProductoReversed());
			}else{
				throw new BadRequestException("The order parameter must be 'album' or '-album'.");
			}
		}
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public LineaPedido get(@PathParam("id") String lineaPedidoId)
	{
		LineaPedido lineaPedido = repository.getLineaPedido(lineaPedidoId);
		
		if(lineaPedido == null) {
			throw new NotFoundException("La línea de pedido con id= " + lineaPedidoId + "no fue encontrada");
		}
		
		return lineaPedido;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLineaPedido(@Context UriInfo uriInfo, LineaPedido lineaPedido) {
		if(lineaPedido.getNombreProducto() == null || "".equals(lineaPedido.getNombreProducto()))
			throw new BadRequestException("El nombre de producto no puede ser nulo");
		
		repository.addLineaPedido(lineaPedido);
		
		//Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(lineaPedido.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(lineaPedido);
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateLineaPedido(LineaPedido lineaPedido) {
		LineaPedido oldlineaPedido = repository.getLineaPedido(lineaPedido.getId());
		if(oldlineaPedido == null) {
			throw new NotFoundException("La línea de pedido con id= " + lineaPedido.getId() + "no fue encontrada");
		}
		
		//Update nombreProducto
		if(lineaPedido.getNombreProducto()!=null) {
			oldlineaPedido.setNombreProducto(lineaPedido.getNombreProducto());
		}
		//Update cantidad
		if(lineaPedido.getCantidad()!=null) {
			oldlineaPedido.setCantidad(lineaPedido.getCantidad());
		}
		
		//Update precioUnitario
		if(lineaPedido.getPrecioUnitario()!=null) {
			oldlineaPedido.setPrecioUnitario(lineaPedido.getPrecioUnitario());
		}
		
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeLineaPedido(@PathParam("id") String lineaPedidoId) {
		LineaPedido toberemoved = repository.getLineaPedido(lineaPedidoId);
		if(toberemoved == null) {
			throw new NotFoundException("La línea de pedido con id= " + lineaPedidoId + "no fue encontrada");
		}else {
			repository.deleteLineaPedido(lineaPedidoId);;
		}
		return Response.noContent().build();
	}
	
}
