package com.df.xkxtbackend.domain.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class Subject {

    @Id
    private String name;

    private String whoCreate;

    private String selectBy;

    private String info;

    private String score;

//    @Column(columnDefinition = "longblob")
    private String profession;

    private Boolean adminIsPass;

    private Boolean teacherIsAgree;

    private String adminNotPassInfo;

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhoCreate() {
        return whoCreate;
    }

    public void setWhoCreate(String whoCreate) {
        this.whoCreate = whoCreate;
    }

    public String getSelectBy() {
        return selectBy;
    }

    public void setSelectBy(String selectBy) {
        this.selectBy = selectBy;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Boolean getAdminIsPass() {
        return adminIsPass;
    }

    public void setAdminIsPass(Boolean adminIsPass) {
        this.adminIsPass = adminIsPass;
    }

    public Boolean getTeacherIsAgree() {
        return teacherIsAgree;
    }

    public void setTeacherIsAgree(Boolean teacherIsAgree) {
        this.teacherIsAgree = teacherIsAgree;
    }

    public String getAdminNotPassInfo() {
        return adminNotPassInfo;
    }

    public void setAdminNotPassInfo(String adminNotPassInfo) {
        this.adminNotPassInfo = adminNotPassInfo;
    }
}
