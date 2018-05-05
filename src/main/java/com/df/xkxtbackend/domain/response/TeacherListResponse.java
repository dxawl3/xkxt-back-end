package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.Teacher;

import java.util.List;

public class TeacherListResponse {

    private List<Teacher> teachers;

    public TeacherListResponse(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
