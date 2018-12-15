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

    public Cliente cadastrar(Cliente client) throws Exception {
         if (!verificaUsername(client.getUsername())) {
        	 this.clientRepository.save(client);
        	 return client;
         } else {
        	 throw new Exception("Cliente já cadastrado!");
         }
    }

    public String excluir(String username) throws Exception {
    	if (verificaUsername(username)) {
    		this.clientRepository.deleteById(username);
    		return "Cliente deletado!";
    	} else {
    		throw new Exception("Cliente não encontrado!");
    	}
    
    }
    
    public boolean verificaUsername(String username) {
    	return this.clientRepository.existsById(username);
    }
    
}