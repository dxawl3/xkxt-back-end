package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudyNumber(String studyNumber);
    List<Student> findAllByName(String name);
}
