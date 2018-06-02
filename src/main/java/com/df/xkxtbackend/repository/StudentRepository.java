package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudyNumber(String studyNumber);

    Student findByName(String name);

    Student findBySelectedSubject(String selectedSubject);
}
