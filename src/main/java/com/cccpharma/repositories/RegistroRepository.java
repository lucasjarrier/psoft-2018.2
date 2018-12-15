package com.cccpharma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cccpharma.models.Registro;

public interface RegistroRepository extends JpaRepository<Registro, String> {

	public Registro findById(@Param("id") Integer id);
}