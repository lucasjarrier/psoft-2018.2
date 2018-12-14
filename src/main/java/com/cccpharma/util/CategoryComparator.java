package com.cccpharma.util;

import java.util.Comparator;

import com.cccpharma.models.Produto;

public class CategoryComparator implements Comparator<Produto> {

	public CategoryComparator() {
		
	}
	
	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getCategoria().compareTo(p2.getCategoria());
	}

}
