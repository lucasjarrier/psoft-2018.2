package com.cccpharma.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "venda")
	private ArrayList<String> venda;
	
	@Column(name = "quantidade_itens")
	private Integer quantidadeItens;
	
	@Column(name = "total")
	private Integer total;

	
	public Registro() {
		
	}
	
	public Registro(Integer id,  Integer quantidadeItens, Integer total) {
		this.id = id;
		this.venda = new ArrayList<String>();
		this.quantidadeItens = quantidadeItens;
		this.total = total;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<String> getVenda() {
		return venda;
	}

	public void setVenda(ArrayList<String> venda) {
		this.venda = venda;
	}

	public Integer getQuantidadeItens() {
		return quantidadeItens;
	}

	public Integer getTotal() {
		return total;
	}
}
