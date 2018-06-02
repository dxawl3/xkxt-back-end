package com.df.xkxtbackend.controller;

import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.model.StudentLog;
import com.df.xkxtbackend.domain.request.StudentLogRequest;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/change_password")
    public Student changePassword(@RequestParam String studyNumber,
                                  @RequestParam String oldPassword,
                                  @RequestParam String newPassword) {
        return studentService.changePassword(studyNumber, oldPassword, newPassword);
    }

    @PostMapping(value = "/select_subject")
    public Subject selectSubject(@RequestParam String studyNumber,
                                 @RequestParam String subjectName) {
        return studentService.selectSubject(studyNumber, subjectName);
    }

    @PostMapping(value = "/change_selected_subject")
    public Subject changeSelectedSubject(@RequestParam String studyNumber,
                                         @RequestParam String oldSubjectName,
                                         @RequestParam String newSubjectName) {
        return studentService.changeSelectedSubject(studyNumber, oldSubjectName, newSubjectName);
    }

    @GetMapping(value = "/get_subject")
    public SubjectListResponse getSubject() {
        return studentService.getSubject();
    }

    @PostMapping(value = "/push_log")
    public Student pushLog(@RequestBody StudentLogRequest studentLogRequest) {
        return studentService.pushLog(studentLogRequest);
    }

    @GetMapping(value = "/get_logs")
    public StudentLog[] getLogs(@RequestParam String name) {
        return studentService.getLogs(name);
    }
}
