package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    Subject findByName(String name);
}
