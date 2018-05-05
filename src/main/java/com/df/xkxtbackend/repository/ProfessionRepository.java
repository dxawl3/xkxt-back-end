package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, String> {
}
