package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.LineaPedido;

public class ComparatorNombreProducto implements Comparator<LineaPedido> {

	@Override
	public int compare(LineaPedido lp1, LineaPedido lp2) {
		// TODO Auto-generated method stub
		return lp1.getNombreProducto().compareTo(lp2.getNombreProducto());
	}
}
