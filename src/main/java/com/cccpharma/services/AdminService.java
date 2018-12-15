package com.cccpharma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccpharma.models.user.Admin;
import com.cccpharma.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public String login(String username, String senha) {
		String retorno;
		Admin admin = adminRepository.findByUsername(username);
		if (admin == null) {
			retorno = "Administrador Invalido";
		}
		else {
			if (senha.equals(admin.getSenha())) {
				retorno = "Administrador Validado";
			}
			else {
				retorno = "Senha Incorreta!";
			}
		}
		return retorno;
	}

}
