package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.LineaPedido;

public class ComparatorPrecioUnitarioReversed implements Comparator<LineaPedido> {

	@Override
	public int compare(LineaPedido lp1, LineaPedido lp2) {
		return lp2.getPrecioUnitario().compareTo(lp1.getPrecioUnitario());
	}

}
