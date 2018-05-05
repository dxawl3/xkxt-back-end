package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Teacher;

public interface TeacherService {
    Teacher login(String teacherNumber, String password);

    Teacher changePassword(String teacherNumber, String oldPassword, String newPassword);
}
