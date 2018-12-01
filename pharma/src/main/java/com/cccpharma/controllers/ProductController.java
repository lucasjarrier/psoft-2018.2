package com.cccpharma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.models.Produto;
import com.cccpharma.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		return new ResponseEntity<Produto>(productService.cadastrar(produto), HttpStatus.OK);
	}

	@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		return new ResponseEntity<String>("Ola!", HttpStatus.OK);
	}
}