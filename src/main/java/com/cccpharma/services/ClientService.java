package com.cccpharma.services;

import java.util.ArrayList;
import java.util.List;

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
    
    public String login(String username, String senha) {
		String retorno;
		if (!verificaUsername(username))
			retorno = "Cliente Invalido!";
		else {
			Cliente cliente = clientRepository.findByUsername(username);
			if (senha.equals(cliente.getSenha()))
				retorno = "Cliente Validado!";
			else
				retorno = "Senha Incorreta!";
		}
		return retorno;
	}
    
	public String adicionaProdutoAoCarrinho(String username, ArrayList<Produto> carrinho) {
		Cliente cliente = clientRepository.findByUsername(username);
		String retorno;
		try {
			cliente.incrementaCarrinho(carrinho);			
			clientRepository.save(cliente);
			retorno = "Carrinho Atualizado";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}
	
	public String removeProdutoAoCarrinho(String username, Produto produto) {
		Cliente cliente = clientRepository.findByUsername(username);
		String retorno;
		try {
			cliente.removeCarrinho(produto);			
			clientRepository.save(cliente);
			retorno = "Carrinho Atualizado";
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}
    
    public boolean verificaUsername(String username) {
    	return this.clientRepository.existsById(username);
    }
    
}