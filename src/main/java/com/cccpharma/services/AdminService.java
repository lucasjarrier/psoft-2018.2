package com.cccpharma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.user.Admin;
import com.cccpharma.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	public String login(String senha) {
		String retorno;
		String senhaAdmin = adminRepository.getAdmin();
		if (senha.equals(senhaAdmin)) {
			retorno = "Administrador Validado";
		} else {
			retorno = "Senha Incorreta!";
		}
		return retorno;
	}
	

}
