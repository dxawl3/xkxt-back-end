package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.entity.Message;
import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.entity.Teacher;
import com.df.xkxtbackend.domain.response.StudentListResponse;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.domain.response.TeacherListResponse;
import com.df.xkxtbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login")
    public void login(@RequestParam String adminUsername,
                      @RequestParam String password) {
        adminService.login(adminUsername, password);
    }

    @PostMapping(value = "/create_student")
    public Student createStudent(@RequestBody Student student) {
        return adminService.createStudent(student);
    }

    @PostMapping(value = "/delete_student")
    public void deleteStudent(@RequestParam String studyNumber) {
        adminService.deleteStudent(studyNumber);
    }

    @PostMapping(value = "/create_teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return adminService.createTeacher(teacher);
    }

    @PostMapping(value = "/delete_teacher")
    public void deleteTeacher(@RequestParam String teacherNumber) {
        adminService.deleteTeacher(teacherNumber);
    }

    @PostMapping(value = "/push_message")
    public Message pushMessage(@RequestBody Message message) {
        return adminService.pushMessage(message);
    }

    @GetMapping(value = "/get_all_student")
    public StudentListResponse getAllStudent() {
        return adminService.getAllStudent();
    }

    @GetMapping(value = "/get_all_teacher")
    public TeacherListResponse getAllTeacher() {
        return adminService.getAllTeacher();
    }

    @GetMapping(value = "/get_all_subject")
    public SubjectListResponse getAllSubject() {
        return adminService.getAllSubject();
    }

    @PostMapping(value = "/pass_subject")
    public Subject passSubject(@RequestParam String subjectName,
                               @RequestParam Boolean adminIsPass) {
            return adminService.passSubject(subjectName, adminIsPass);
    }
}
