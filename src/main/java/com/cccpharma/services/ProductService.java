package com.cccpharma.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.Produto;
import com.cccpharma.models.user.Cliente;
import com.cccpharma.repositories.ProductRepository;
import com.cccpharma.util.CategoryComparator;
import com.cccpharma.util.NameComparator;
import com.cccpharma.util.PriceComparator;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public List<Produto> getAll() {
    	List<Produto> retorno = new ArrayList<>();
    	for (Produto produto : this.productRepository.findAll()) {
			if(!produto.getSituacao())
				produto.setPreco(00.00);
			retorno.add(produto);
		}
        return retorno;
    }
    
    public boolean verificaCodigo(String codigo) {
    	return this.productRepository.existsById(codigo);
    }
    
    public Produto cadastrar(Produto produto) throws Exception {
    	if (!verificaCodigo(produto.getCodigo())) {
    		this.productRepository.save(produto);
    		return produto;
    	} else {
    		throw new Exception("Produto já cadastrado!");
    	}
	}

    public Produto findByNome(String nome) {
        return this.productRepository.findByNome(nome);
    }
    
    public Double mudarPreco(String codigo, Double preco) throws Exception {
    	if (verificaCodigo(codigo) && preco >= 0) {
    		this.productRepository.mudarPreco(codigo, preco);
    		return preco;
    	} else {
    		throw new Exception("Produto não cadastrado ou preço inválido!");
    	}
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
