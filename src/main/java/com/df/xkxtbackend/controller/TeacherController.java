package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.entity.Teacher;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/login")
    public Teacher login(@RequestParam String teacherNumber,
                         @RequestParam String password) {
        return teacherService.login(teacherNumber, password);
    }

    @PostMapping(value = "/change_password")
    public Teacher changePassword(@RequestParam String teacherNumber,
                                  @RequestParam String oldPassword,
                                  @RequestParam String newPassword) {
        return teacherService.changePassword(teacherNumber, oldPassword, newPassword);
    }

    @PostMapping(value = "/create_subject")
    public Subject createSubject(@RequestBody Subject subject) {
        return teacherService.createSubject(subject);
    }

    @PostMapping(value = "/delete_subject")
    public void deleteSubject(@RequestParam String subjectName) {
        teacherService.deleteSubject(subjectName);
    }

    @PostMapping(value = "/update_score")
    public Subject updateScore(@RequestParam String subjectName,
                               @RequestParam String score) {
        return teacherService.updateScore(subjectName, score);
    }

    @GetMapping(value = "/get_subject")
    public SubjectListResponse getSubject(@RequestParam String teacherNumber) {
        return teacherService.getSubject(teacherNumber);
    }

    @PostMapping(value = "/agree_select")
    public Subject agreeSelect(@RequestParam String subjectName,
                               @RequestParam Boolean teacherIsAgree) {
        return teacherService.agreeSelect(subjectName, teacherIsAgree);
    }
}
