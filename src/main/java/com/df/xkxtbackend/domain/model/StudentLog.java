package com.df.xkxtbackend.domain.model;

import java.util.Date;

public class StudentLog implements java.io.Serializable {

    private String title;

    private Date date;

    private String content;

    public StudentLog() {
    }

    public StudentLog(String title, Date date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
