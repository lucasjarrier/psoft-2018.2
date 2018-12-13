package com.cccpharma.services;

import java.util.Collections;
import java.util.List;

import com.cccpharma.models.Produto;
import com.cccpharma.repositories.ProductRepository;
import com.cccpharma.util.MeuComparador;

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
    
    public int mudarPreco(String codigo, Double preco) {
    	return this.productRepository.mudarPreco(codigo, preco);
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
    
    public void deleteProduct(Produto p) {
    	this.productRepository.delete(p);
    }

    public List<Produto> orderByNome() {
        List<Produto> list = this.getAll();
        Collections.sort(list, new MeuComparador(MeuComparador.POR_NOME));
        return list;
    }

    public List<Produto> orderByPrice() {
        List<Produto> list = this.getAll();
        Collections.sort(list, new MeuComparador(MeuComparador.POR_PRECO));
        return list;
    }
}