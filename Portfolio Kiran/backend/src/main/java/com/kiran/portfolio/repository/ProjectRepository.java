package com.kiran.portfolio.repository;

import com.kiran.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}