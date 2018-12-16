package com.cccpharma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.user.Admin;
import com.cccpharma.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public Boolean login(String senha) {
		Boolean retorno = false;
		String senhaAdmin = adminRepository.getAdmin();
		if (senha.equals(senhaAdmin))
			retorno = true;
		return retorno;
	}
	
	public String criaAdmin() {
		Admin admin = new Admin("admin","12345");
		adminRepository.save(admin);
		return "Admin Cadastrado";
	}
	
	
	public List<Admin> get() {
		return this.adminRepository.findAll();
	}
	

}
