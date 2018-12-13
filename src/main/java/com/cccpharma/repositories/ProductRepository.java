package com.cccpharma.repositories;

import com.cccpharma.models.Produto;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Produto, String> {

	Produto findByNome(@Param("nome") String nome);
	
	Produto findByCodigo(@Param("codigo") String codigo);

	@Modifying
	@Transactional
	@Query("update Produto p set p.preco = ?2 where p.codigo = ?1")
	int mudarPreco(String codigo, Double preco);
	
}