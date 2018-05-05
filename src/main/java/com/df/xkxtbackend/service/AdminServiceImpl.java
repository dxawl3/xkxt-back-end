package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.entity.Message;
import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.entity.Teacher;
import com.df.xkxtbackend.domain.response.StudentListResponse;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.domain.response.TeacherListResponse;
import com.df.xkxtbackend.exception.IllegalParameterException;
import com.df.xkxtbackend.repository.MessageRepository;
import com.df.xkxtbackend.repository.StudentRepository;
import com.df.xkxtbackend.repository.SubjectRepository;
import com.df.xkxtbackend.repository.TeacherRepository;
import com.df.xkxtbackend.util.MD5EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private Subject subject;

    @Override
    public void login(String adminUsername, String password) {
        if (!adminUsername.equals("admin")) {
            throw new IllegalParameterException("【用户名不存在】");
        }

        if (!password.equals("12345")) {
            throw new IllegalParameterException("【管理员密码错误】");
        }
    }

    @Override
    public Student createStudent(Student student) {
        student.setPassword(MD5EncodeUtil.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String studyNumber) {
        studentRepository.deleteById(studyNumber);
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        teacher.setPassword(MD5EncodeUtil.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(String teacherNumber) {
        teacherRepository.deleteById(teacherNumber);
    }

    @Override
    public Message pushMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public StudentListResponse getAllStudent() {
        return new StudentListResponse(studentRepository.findAll());
    }

    @Override
    public TeacherListResponse getAllTeacher() {
        return new TeacherListResponse(teacherRepository.findAll());
    }

    @Override
    public SubjectListResponse getAllSubject() {
        return new SubjectListResponse(subjectRepository.findAll());
    }

    @Override
    public Subject passSubject(String subjectName, Boolean adminIsPass) {
        subject = subjectRepository.findByName(subjectName);
        subject.setAdminIsPass(adminIsPass);
        return subjectRepository.save(subject);
    }
}
