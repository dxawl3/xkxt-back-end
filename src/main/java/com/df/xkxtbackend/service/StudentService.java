package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Student;

public interface StudentService {
    Student login(String studyNumber, String password);
}
