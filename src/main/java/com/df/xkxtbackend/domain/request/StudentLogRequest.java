package com.df.xkxtbackend.domain.request;

import com.df.xkxtbackend.domain.model.StudentLog;

public class StudentLogRequest {

    private String studyNumber;

    private StudentLog studentLog;

    public String getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(String studyNumber) {
        this.studyNumber = studyNumber;
    }

    public StudentLog getStudentLog() {
        return studentLog;
    }

    public void setStudentLog(StudentLog studentLog) {
        this.studentLog = studentLog;
    }
}
