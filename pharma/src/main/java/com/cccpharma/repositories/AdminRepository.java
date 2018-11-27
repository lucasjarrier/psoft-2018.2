package com.cccpharma.repositories;

import com.cccpharma.models.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {


}