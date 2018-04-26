package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.Student;
import com.df.xkxtbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/login")
    public Student login(@RequestParam String studyNumber,
                         @RequestParam String password) {
        return studentService.login(studyNumber, password);
    }
}
