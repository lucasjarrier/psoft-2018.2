package com.cccpharma.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nome")
    @NotNull(message = "Nome não pode ser nulo!")
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;


    @Column(name = "fabricante")
    @NotNull(message = "Nome do fabricante não pode ser nulo!")
    @NotEmpty(message = "Nome do fabricante não pode ser vazio!")
    private String fabricante;

    // Atributo situação.

    @Check(constraints = "categoria = medicamento or categoria = higiene or categoria = cosmetico or categoria = alimento")
    @Column(name = "categoria")
    @NotNull(message = "Categoria do produto não pode ser nula!")
    @NotEmpty(message = "Categoria do produto não pode ser vazia!")
    private String categoria;

    public Produto() {
        
    }

    public Produto(String codigo, String nome, String fabricante, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFabricante() {
        return this.fabricante;
    }   

    public String getCategoria() {
        return this.categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   

}