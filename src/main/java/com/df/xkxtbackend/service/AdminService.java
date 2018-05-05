package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Message;
import com.df.xkxtbackend.domain.Student;
import com.df.xkxtbackend.domain.Subject;
import com.df.xkxtbackend.domain.Teacher;
import com.df.xkxtbackend.domain.response.StudentListResponse;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.domain.response.TeacherListResponse;

public interface AdminService {
    void login(String adminUsername, String password);

    Student createStudent(Student student);

    void deleteStudent(String studyNumber);

    Teacher createTeacher(Teacher teacher);

    void deleteTeacher(String teacherNumber);

    Message pushMessage(Message message);

    StudentListResponse getAllStudent();

    TeacherListResponse getAllTeacher();

    SubjectListResponse getAllSubject();

    Subject passSubject(String subjectName, Boolean adminIsPass);
}
