package com.cccpharma.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.models.Registro;
import com.cccpharma.services.RegistroService;

@RestController
public class RegistroController {

	@Autowired
	RegistroService registroService;
	
	@RequestMapping(value = "/registro/novoRegistro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String criarRegistro(@RequestBody ArrayList<String> codigos) throws Exception {
		return this.registroService.criarRegistro(codigos);
	}
	
	@RequestMapping(value = "/registro/listarRegistros", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Registro> listarRegistros() {
		return this.registroService.listarRegistros();
	}
	
	@RequestMapping(value = "/registro/pesquisarRegistro/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Registro procurarRegistro(@PathVariable int id) {
		return this.registroService.procurarRegistro(id);
	}
}