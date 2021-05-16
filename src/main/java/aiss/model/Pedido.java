package aiss.model;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.repackaged.org.joda.time.LocalDate;

public class Pedido {

	private String id;
	private String nombreCliente;
	private Integer precioPedido;
	//private LocalDate fechaPedido;
	private List<LineaPedido> lineasPedido;
	
	
	public Pedido() {
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public Integer getPrecioPedido() {
		return precioPedido;
	}


	public void setPrecioPedido(Integer precioPedido) {
		this.precioPedido = precioPedido;
	}


	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	
	public LineaPedido getLineaPedido(String id) {
		if (lineasPedido==null)
			return null;
		
		LineaPedido lineaPedido = null;
		for(LineaPedido lp: lineasPedido)
			if (lp.getId().equals(id))
			{
				lineaPedido = lp;
				break;
			}
		
		return lineaPedido;
	}


	public void addLineaPedido(LineaPedido lp) {
		if (lineasPedido==null)
			lineasPedido = new ArrayList<LineaPedido>();
		lineasPedido.add(lp);
	}
	
	public void deleteLineaPedido(LineaPedido lp) {
		lineasPedido.remove(lp);
	}
	
	public void deleteLineaPedido(String id) {
		LineaPedido lp = getLineaPedido(id);
		if (lp!=null)
			lineasPedido.remove(lp);
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
}
