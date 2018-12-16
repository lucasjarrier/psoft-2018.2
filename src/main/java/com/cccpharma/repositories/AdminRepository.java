package com.cccpharma.repositories;

import com.cccpharma.models.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	public Admin findByUsername(@Param("username") String username);
	
	@Query("select a.senha from Admin a where a.username='admin'")
	public String getAdmin();
	
}