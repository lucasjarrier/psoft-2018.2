package com.cccpharma.repositories;

import com.cccpharma.models.user.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Cliente, String> {

	public Cliente findByUsername(@Param("username") String username);
}