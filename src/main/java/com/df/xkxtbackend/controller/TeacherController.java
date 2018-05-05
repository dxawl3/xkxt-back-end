package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.Teacher;
import com.df.xkxtbackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
