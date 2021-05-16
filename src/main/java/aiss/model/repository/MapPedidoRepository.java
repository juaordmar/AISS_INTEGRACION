package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Pedido;
import aiss.model.LineaPedido;

public class MapPedidoRepository implements PedidoRepository {
	
	Map<String, Pedido> pedidoMap;
	Map<String, LineaPedido> lineaPedidoMap;
	private static MapPedidoRepository instance=null;
	private int index=0;			
	
	
	public static MapPedidoRepository getInstance() {
		
		if (instance==null) {
			instance = new MapPedidoRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		pedidoMap = new HashMap<String,Pedido>();
		lineaPedidoMap = new HashMap<String,LineaPedido>();
		
		LineaPedido lpedido1=new LineaPedido();
		lpedido1.setNombreProducto("Sudadera Collusion");
		lpedido1.setCantidad(1);
		lpedido1.setPrecioUnitario(28.99f);
		addLineaPedido(lpedido1);
		
		LineaPedido lpedido2=new LineaPedido();
		lpedido2.setNombreProducto("ColaCao");
		lpedido2.setCantidad(5);
		lpedido2.setPrecioUnitario(30f);
		addLineaPedido(lpedido2);
		
		LineaPedido lpedido3=new LineaPedido();
		lpedido3.setNombreProducto("Aguacates Reina");
		lpedido3.setCantidad(3);
		lpedido3.setPrecioUnitario(1.49f);
		addLineaPedido(lpedido3);
		
		
		LineaPedido lpedido4=new LineaPedido();
		lpedido4.setNombreProducto("Platanos Ordoñez");
		lpedido4.setCantidad(6);
		lpedido4.setPrecioUnitario(0.59f);
		addLineaPedido(lpedido4);
		
		Pedido pedido1=new Pedido();
		pedido1.setNombreCliente("Francisco Perez");
		pedido1.setPrecioPedido(50);
		//pedido1.setLineasPedido("A sample lpedido 1");
		addPedido(pedido1);
		
		Pedido pedido2 = new Pedido();
		pedido2.setNombreCliente("Juan García");
		pedido2.setPrecioPedido(44);
		//pedido2.setLineasPedido("A sample lpedido 2");
		addPedido(pedido2);
		
		// Add LP to pedido
		addLineaPedido(pedido1.getId(), lpedido1.getId());
		addLineaPedido(pedido1.getId(), lpedido2.getId());
		addLineaPedido(pedido1.getId(), lpedido3.getId());
		addLineaPedido(pedido1.getId(), lpedido4.getId());
		
		
		addLineaPedido(pedido2.getId(), lpedido3.getId());
		addLineaPedido(pedido2.getId(), lpedido1.getId());
	}
	
	// Playlist related operations
	@Override
	public void addPedido(Pedido p) {
		String id = "p" + index++;	
		p.setId(id);
		pedidoMap.put(id,p);
	}
	
	@Override
	public Collection<Pedido> getAllPedidos() {
			return pedidoMap.values();
	}

	@Override
	public Pedido getPedido(String id) {
		return pedidoMap.get(id);
	}
	
	@Override
	public void updatePedido(Pedido p) {
		pedidoMap.put(p.getId(),p);
	}

	@Override
	public void deletePedido(String id) {	
		pedidoMap.remove(id);
	}
	

	@Override
	public void addLineaPedido(String pedidoId, String lineaPedidoId) {
		Pedido pedido = getPedido(pedidoId);
		pedido.addLineaPedido(lineaPedidoMap.get(lineaPedidoId));
	}

	@Override
	public Collection<LineaPedido> getAll(String pedidoId) {
		return getPedido(pedidoId).getLineasPedido();
	}

	@Override
	public void removeLineaPedido(String pedidoId, String lineaPedidoId) {
		getPedido(pedidoId).deleteLineaPedido(lineaPedidoId);
	}

	
	
	@Override
	public void addLineaPedido(LineaPedido lp) {
		String id = "lp" + index++;
		lp.setId(id);
		lineaPedidoMap.put(id, lp);
	}
	
	@Override
	public Collection<LineaPedido> getAllLineaPedidos() {
			return lineaPedidoMap.values();
	}

	@Override
	public LineaPedido getLineaPedido(String lineaPedidoId) {
		return lineaPedidoMap.get(lineaPedidoId);
	}

	@Override
	public void updateLineaPedido(LineaPedido lp) {
		LineaPedido lineaPedido = lineaPedidoMap.get(lp.getId());
		//lineaPedido.setLineaPedidoId(s.getTitle());
		lineaPedido.setPrecioUnitario(lp.getPrecioUnitario());
		lineaPedido.setNombreProducto(lp.getNombreProducto());
		lineaPedido.setCantidad(lp.getCantidad());
	}

	@Override
	public void deleteLineaPedido(String lineaPedidoId) {
		lineaPedidoMap.remove(lineaPedidoId);
	}

}