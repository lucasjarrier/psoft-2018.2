package com.cccpharma.util;

import java.util.Comparator;

import com.cccpharma.models.Produto;

public class NameComparator implements Comparator<Produto> {

	public NameComparator() {
		
	}
	
	@Override
	public int compare(Produto p1, Produto p2) {
		return p1.getNome().compareTo(p2.getNome());
	}

}
