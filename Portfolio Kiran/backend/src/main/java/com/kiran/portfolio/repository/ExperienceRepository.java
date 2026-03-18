package com.kiran.portfolio.repository;

import com.kiran.portfolio.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}