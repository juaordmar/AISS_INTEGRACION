package aiss.model.repository;

import java.util.Collection;

import aiss.model.LineaPedido;
import aiss.model.Pedido;

public interface PedidoRepository {
	
	
	// LineasPedido
	public void addLineaPedido(LineaPedido lp);
	public Collection<LineaPedido> getAllLineaPedidos();
	public LineaPedido getLineaPedido(String lpId);
	public void updateLineaPedido(LineaPedido lp);
	public void deleteLineaPedido(String lpId);
	
	// Pedidos
	public void addPedido(Pedido p);
	public Collection<Pedido> getAllPedidos();
	public Pedido getPedido(String pedidoId);
	public void updatePedido(Pedido p);
	public void deletePedido(String pedidoId);
	public Collection<LineaPedido> getAll(String pedidoId);
	public void addLineaPedido(String pedidoId, String lpId);
	public void removeLineaPedido(String pedidoId, String lpId);

	
	
	
	

}
