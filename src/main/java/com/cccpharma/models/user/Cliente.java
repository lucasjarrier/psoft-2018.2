package com.cccpharma.models.user;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cccpharma.models.Produto;


@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "nome")
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;


    @Column(name = "email")
    @NotNull(message = "Email não pode ser nulo!")
    @NotEmpty(message = "Email não pode ser vazio!")
    private String email;
    
    private ArrayList<Produto> carrinho = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String username, String nome, String email) {
        this.username = username;
        this.nome = nome;
        this.email = email;
    }
    
     public ArrayList<Produto> getCarrinho() {
         return this.carrinho;
     }
    
     public void setCarrinho(ArrayList<Produto> carrinho) {
         this.carrinho = carrinho;
     }

    public String getUsername() {
        return this.username;
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
