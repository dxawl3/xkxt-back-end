package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Student;
import com.df.xkxtbackend.domain.Subject;
import com.df.xkxtbackend.domain.request.StudentLogRequest;
import com.df.xkxtbackend.domain.response.SubjectListResponse;

public interface StudentService {
    Student login(String studyNumber, String password);

    Student changePassword(String studyNumber, String oldPassword, String newPassword);

    Subject selectSubject(String studyNumber, String subjectName);

    Subject changeSelectedSubject(String studyNumber, String oldSubjectName, String newSubjectName);

    SubjectListResponse getSubject();

    Student pushLog(StudentLogRequest studentLogRequest);
}
