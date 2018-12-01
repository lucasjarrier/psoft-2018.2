package com.cccpharma.repositories;

import com.cccpharma.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Produto, String> {

	Produto findByNome(@Param("nome") String nome);
	
	Produto findByCodigo(@Param("codigo") String codigo);

}