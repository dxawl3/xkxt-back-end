package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.entity.Teacher;
import com.df.xkxtbackend.domain.response.SubjectListResponse;

public interface TeacherService {
    Teacher login(String teacherNumber, String password);

    Teacher changePassword(String teacherNumber, String oldPassword, String newPassword);

    Subject createSubject(Subject subject);

    void deleteSubject(String subjectName);

    Subject updateScore(String subjectName, String score);

    Subject agreeSelect(String subjectName, String teacherIsAgree);

    SubjectListResponse getSubject(String teacherNumber);
}
