package com.cccpharma.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "senha")
    @NotNull(message = "Senha não pode ser nulo!")
    @NotEmpty(message = "Senha não pode ser vazio!")
    private String senha;

    public Admin() {

    }

    public Admin(String username, String senha) {
    	 this.username = username;
         this.senha = senha;
    }

    public String getUsername() {
        return this.username;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}