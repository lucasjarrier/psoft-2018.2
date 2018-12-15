package com.cccpharma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.models.user.Cliente;
import com.cccpharma.services.ClientService;

@CrossOrigin(value ="*")
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
	
	@RequestMapping(value = "/clientes/cadastrar/validausername/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public boolean validaUsername(@PathVariable String username) {
		return !(this.clientService.verificaUsername(username));
	}
	
	@RequestMapping(value = "/clientes/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String login(@RequestBody String username, @RequestBody String senha) throws Exception {
		return this.clientService.login(username, senha);
	}

}
