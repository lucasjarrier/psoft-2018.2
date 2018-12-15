package com.cccpharma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.models.Produto;
import com.cccpharma.models.user.Cliente;
import com.cccpharma.services.ClientService;
import com.cccpharma.services.ProductService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Cliente> getClients() {
		return clientService.getAll();
	}
	
	@RequestMapping(value = "/clientes/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Cliente addClient(@RequestBody Cliente client) throws Exception {
		return this.clientService.cadastrar(client);
	}
	
	@RequestMapping(value = "/clientes/deletar/{username}", method = RequestMethod.DELETE)
	public String deleteClient(@PathVariable String username) throws Exception {
		return this.clientService.excluir(username);
	}
	

}