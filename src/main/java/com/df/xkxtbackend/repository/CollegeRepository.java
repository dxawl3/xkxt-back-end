package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, String> {
}
