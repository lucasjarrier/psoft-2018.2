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

    @Column(name = "nome")
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;

    @Column(name = "senha")
    @NotNull(message = "Senha não pode ser nulo!")
    @NotEmpty(message = "Senha não pode ser vazio!")
    private String senha;

    public Admin() {

    }

    public Admin(String username, String nome, String senha) {
    	 this.username = "Thallysinho xD";
         this.nome = "Thallyson";
         this.senha = "123456789";
    }

    public String getUsername() {
        return this.username;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

}