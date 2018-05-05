package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Teacher findByTeacherNumber(String teacherNumber);
}
