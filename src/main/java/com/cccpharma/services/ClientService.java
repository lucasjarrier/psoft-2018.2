package com.cccpharma.services;

import java.util.List;

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

    
}