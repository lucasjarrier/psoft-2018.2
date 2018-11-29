package com.cccpharma.models;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Column(name = "situacao")
    @NotNull(message = "Situação não pode ser nula!")
    @NotEmpty(message = "Situação não pode ser vazia!")
    private boolean situacao;

    @Column(name = "categoria")
    @NotNull(message = "Categoria do produto não pode ser nula!")
    @NotEmpty(message = "Categoria do produto não pode ser vazia!")
    private String categoria;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade")
    @NotNull(message = "Quantidade não pode ser nula!")
    @NotEmpty(message = "Quantidade não pode ser vazia!")
    private Integer quantidade;

    public Produto() {
        
    }

    public Produto(String codigo, String nome, String fabricante, boolean situacao, String categoria, 
    Double preco, Integer quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.fabricante = fabricante;
        this.situacao = situacao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public boolean getSituacao() {
        return this.situacao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }
}