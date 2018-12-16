package com.cccpharma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.services.AdminService;
import com.cccpharma.models.user.*;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Boolean login(@RequestBody String senha) {
		return this.adminService.login(senha);
	}
	
	
	@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String criaAdmin() {
		return this.adminService.criaAdmin();
	}
	
	@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Admin> get() {
		return this.adminService.get();
	}
}