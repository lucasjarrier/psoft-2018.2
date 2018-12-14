package com.cccpharma.services;

import java.util.Collections;
import java.util.List;

import com.cccpharma.models.Produto;
import com.cccpharma.models.user.Cliente;
import com.cccpharma.repositories.ProductRepository;
import com.cccpharma.util.CategoryComparator;
import com.cccpharma.util.NameComparator;
import com.cccpharma.util.PriceComparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public List<Produto> getAll() {
        return this.productRepository.findAll();
    }
    
    public Produto cadastrar(Produto produto) {
		return this.productRepository.save(produto);
	}

    public Produto findByNome(String nome) {
        return this.productRepository.findByNome(nome);
    }
    
    public Double mudarPreco(String codigo, Double preco) {
    	this.productRepository.mudarPreco(codigo, preco);
    	return preco;
    }
    
    public Produto findByCodigo(String codigo) {
    	return this.productRepository.findByCodigo(codigo);
    }

    public Boolean getDisponibilidadeProduto(String nome) {
        Produto p = this.productRepository.findByNome(nome);
        return p.getSituacao();
    }

    public Double getPrecoProduto(String nome) {
        Produto p = this.productRepository.findByNome(nome);
        return p.getPreco();
    }
    
    public void setPrecoProduto(String nome, Double preco) {
        Produto p = this.productRepository.findByNome(nome);
        p.setPreco(preco);
    }
    
    public Produto deleteProduct(String codigo) {
    	Produto p = this.productRepository.findByCodigo(codigo);
    	this.productRepository.delete(p);
    	return p;
    }
    
    public List<Produto> orderByNome() {
        List<Produto> list = this.getAll();
        Collections.sort(list, new NameComparator());
        return list;
    }

    public List<Produto> orderByPrice() {
        List<Produto> list = this.getAll();
        Collections.sort(list, new PriceComparator());
        return list;
    }
    
    public List<Produto> orderByCategory() {
    	List<Produto> list = this.getAll();
    	Collections.sort(list, new CategoryComparator());
    	return list;
    }
    
    public void atribuirDesconto(String categoria, Integer desconto) {
		this.productRepository.atribuirDesconto(categoria, desconto);
	}
    
    public void addCarrinho(Cliente c, Produto p) {
    	c.getCarrinho().add(p);
    }
    
}
