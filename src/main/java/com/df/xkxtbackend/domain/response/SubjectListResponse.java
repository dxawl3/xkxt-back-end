package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.entity.Subject;

import java.util.List;

public class SubjectListResponse {

    private List<Subject> subjects;

    public SubjectListResponse(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
