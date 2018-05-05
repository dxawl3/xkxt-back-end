package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.entity.Student;

import java.util.List;

public class StudentListResponse {

    private List<Student> students;

    public StudentListResponse(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
