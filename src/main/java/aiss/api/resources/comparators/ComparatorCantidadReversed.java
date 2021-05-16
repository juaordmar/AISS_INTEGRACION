package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.LineaPedido;

public class ComparatorCantidadReversed implements Comparator<LineaPedido> {

	@Override
	public int compare(LineaPedido lp1, LineaPedido lp2) {
		// TODO Auto-generated method stub
		return lp2.getCantidad().compareTo(lp1.getCantidad());
	}

}
