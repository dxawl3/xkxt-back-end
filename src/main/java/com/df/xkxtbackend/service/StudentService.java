package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.model.StudentLog;
import com.df.xkxtbackend.domain.request.StudentLogRequest;
import com.df.xkxtbackend.domain.response.SubjectListResponse;

import java.util.List;

public interface StudentService {
    Student login(String studyNumber, String password);

    Student changePassword(String studyNumber, String oldPassword, String newPassword);

    Subject selectSubject(String studyNumber, String subjectName);

    Subject changeSelectedSubject(String studyNumber, String oldSubjectName, String newSubjectName);

    SubjectListResponse getSubject();

    Student pushLog(StudentLogRequest studentLogRequest);

    StudentLog[] getLogs(String name);
}
