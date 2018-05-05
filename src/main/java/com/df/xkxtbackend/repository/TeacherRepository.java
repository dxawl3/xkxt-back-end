package com.df.xkxtbackend.repository;

import com.df.xkxtbackend.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Teacher findByTeacherNumber(String teacherNumber);

    Teacher findByName(String name);
}
