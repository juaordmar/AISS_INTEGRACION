package aiss.model;


public class LineaPedido {

	private String id;
	private String nombreProducto;
	private Integer cantidad;
	private Float precioUnitario;
	
	
	public LineaPedido() {
	}

	public LineaPedido(String nombreProducto, Integer cantidad, Float precioUnitario) {
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	
	public LineaPedido(String id, String nombreProducto, Integer cantidad, Float precioUnitario) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
