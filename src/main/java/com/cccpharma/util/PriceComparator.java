package com.cccpharma.util;

import java.util.Comparator;

import com.cccpharma.models.Produto;

public class PriceComparator implements Comparator<Produto>{

	public PriceComparator() {
		
	}
	
	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getPreco().compareTo(p2.getPreco());
	}

}
