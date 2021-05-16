package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.LineaPedido;

public class ComparatorPrecioUnitario implements Comparator<LineaPedido> {

	@Override
	public int compare(LineaPedido lp1, LineaPedido lp2) {
		return lp1.getPrecioUnitario().compareTo(lp2.getPrecioUnitario());
	}

}
