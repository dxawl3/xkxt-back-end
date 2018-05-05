package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, String> {
}
