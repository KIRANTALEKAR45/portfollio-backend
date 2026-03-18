package com.kiran.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kiran.portfolio.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
Admin findByUsername(String username);
}
