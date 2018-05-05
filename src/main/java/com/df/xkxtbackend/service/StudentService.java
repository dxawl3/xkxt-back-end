package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Student;
import com.df.xkxtbackend.domain.Subject;
import com.df.xkxtbackend.domain.request.StudentLogRequest;

public interface StudentService {
    Student login(String studyNumber, String password);

    Student changePassword(String studyNumber, String oldPassword, String newPassword);

    Subject selectSubject(String studyNumber, String subjectName);

    Student pushLog(StudentLogRequest studentLogRequest);
}
