package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    Subject findByName(String name);

    List<Subject> findAllByWhoCreate(String whoCreate);
}
