package com.cccpharma.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;


    @Column(name = "email")
    @NotNull(message = "Email não pode ser nulo!")
    @NotEmpty(message = "Email não pode ser vazio!")
    private String email;

    public Admin() {

    }

    public Admin(@Size(min = 11, max = 11) String cpf, 
    String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}