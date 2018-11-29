package com.cccpharma.repositories;

import java.util.List;

import com.cccpharma.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Produto, String> {

    @Query("select nome from Produto p where p.nome = ?1")
    Produto findByNome(String nome);

    @Query("select preco from Produto p where p.preco = ?1")
    Produto findByPreco(Double preco);

    @Query("select categoria from Produto p where p.categoria = ?1")
    Produto findByCategoria(String categoria);

}