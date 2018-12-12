package com.cccpharma.models.user;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cccpharma.models.Produto;


@Entity
@Table(name = "cliente")
public class Cliente {

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
    
    @OneToMany
    @JoinColumn(name = "carrinho", referencedColumnName = "codigo")
    private Set<Produto> carrinho = new HashSet<>();

    public Cliente() {

    }

    public Cliente(@Size(min = 11, max = 11) String cpf, 
    String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    
    public Set<Produto> getCarrinho() {
        return this.carrinho;
    }
    
    public void setCarrinho(Set<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
//     public List<Produto> getCarrinho() {
//         return this.carrinho;
//     }
    
//     public void setCarrinho(List<Produto> car) {
//         this.carrinho = car;
//     }
    
//     public void addProduto(Produto produto) {
//     	this.carrinho.add(produto);
//     }
    
//     public void removeProduto(Produto produto) {
//     	this.carrinho.remove(produto);
//     }

}
