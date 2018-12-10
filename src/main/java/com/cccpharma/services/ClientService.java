package com.cccpharma.services;

import java.util.List;
import java.util.Optional;

import com.cccpharma.models.Produto;
import com.cccpharma.models.user.Cliente;
import com.cccpharma.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Cliente> getAll() {
        return this.clientRepository.findAll();
    }

    public Cliente cadastrar(Cliente client) {
         this.clientRepository.save(client);
         return client;
    }

    public String excluir(String cpf) {
    	this.clientRepository.deleteById(cpf);
    	return "Cliente deletado!";
    }
    
    public void addProduto(String cpf, Produto product) throws Exception {
    	Optional<Cliente> c = this.clientRepository.findById(cpf);
    	if (!c.isPresent()) {
    		throw new Exception("Client doesn't exist!");
    	}
    	
    	if (!product.getSituacao()) {
    		throw new Exception("Product doesn't exist!");
    	}
    	Cliente aux = c.get();
    	aux.addProduto(product);
    	this.clientRepository.save(aux);
    }
    
    public void removeProduto(String cpf, Produto product) throws Exception {
    	Optional<Cliente> c = this.clientRepository.findById(cpf);
    	if (!c.isPresent()) {
    		throw new Exception("Client doesn't exists!");
    	}
    	
    	if (!product.getSituacao()) {
    		throw new Exception("Product doesn't exists!");
    	}
    	Cliente aux = c.get();
    	aux.removeProduto(product);
    	this.clientRepository.save(aux);
    	
    }
    
}