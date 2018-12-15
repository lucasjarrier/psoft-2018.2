package com.cccpharma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cccpharma.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String login(@RequestBody String username, @RequestBody String senha) {
		return this.adminService.login(username, senha);
	}
}