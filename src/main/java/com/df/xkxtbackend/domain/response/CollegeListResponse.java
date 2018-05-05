package com.df.xkxtbackend.domain.response;

import com.df.xkxtbackend.domain.entity.College;

import java.util.List;

public class CollegeListResponse {

    private List<College> colleges;

    public CollegeListResponse(List<College> colleges) {
        this.colleges = colleges;
    }

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }
}
