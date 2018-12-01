package com.cccpharma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public List<Cliente> get() {
		return clientService.getAll();
	}
}