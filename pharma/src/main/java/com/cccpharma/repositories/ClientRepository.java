package com.cccpharma.repositories;

import com.cccpharma.models.user.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, String> {


}