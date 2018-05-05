package com.df.xkxtbackend.domain.entity;

import com.df.xkxtbackend.domain.model.StudentLog;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Component
public class Student {

    @Id
    private String studyNumber;

    private String name;

    private String password;

    private String profession;

    private String classes;

    private String selectedSubject;

    private Boolean teacherIsAgree;

    private String score;

    @Column(columnDefinition = "longblob")
    private StudentLog[] studentLogs;

    public Student() {
    }

    public String getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(String studyNumber) {
        this.studyNumber = studyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(String selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public Boolean getTeacherIsAgree() {
        return teacherIsAgree;
    }

    public void setTeacherIsAgree(Boolean teacherIsAgree) {
        this.teacherIsAgree = teacherIsAgree;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public StudentLog[] getStudentLogs() {
        return studentLogs;
    }

    public void setStudentLogs(StudentLog[] studentLogs) {
        this.studentLogs = studentLogs;
    }
}
