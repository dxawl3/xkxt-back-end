package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.entity.Teacher;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.exception.BeyondMaxException;
import com.df.xkxtbackend.exception.IllegalParameterException;
import com.df.xkxtbackend.repository.StudentRepository;
import com.df.xkxtbackend.repository.SubjectRepository;
import com.df.xkxtbackend.repository.TeacherRepository;
import com.df.xkxtbackend.util.MD5EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private Teacher teacher;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Student student;

    @Autowired
    private Subject subject;

    @Override
    public Teacher login(String teacherNumber, String password) {
        // 判断教师用户是否存在
        if (teacherRepository.findByTeacherNumber(teacherNumber) == null) {
            throw new IllegalParameterException("【教师账户不存在】");
        }

        // 判断密码是否正确
        if (!teacherRepository.findByTeacherNumber(teacherNumber).getPassword().equals(MD5EncodeUtil.encode(password))) {
            throw new IllegalParameterException("【密码错误】");
        }

        return teacherRepository.findByTeacherNumber(teacherNumber);
    }

    @Override
    public Teacher changePassword(String teacherNumber, String oldPassword, String newPassword) {
        // 判断原密码是否正确
        if (!teacherRepository.findByTeacherNumber(teacherNumber).getPassword().equals(MD5EncodeUtil.encode(oldPassword))) {
            throw new IllegalParameterException("【原密码错误】");
        }

        teacher = teacherRepository.findByTeacherNumber(teacherNumber);
        teacher.setPassword(MD5EncodeUtil.encode(newPassword));
        return teacherRepository.save(teacher);
    }

    @Override
    public Subject createSubject(Subject subject) {
        if (subjectRepository.findAllByWhoCreate(subject.getWhoCreate()).size() >= teacherRepository.findByName(subject.getWhoCreate()).getAllowMax()) {
            throw new BeyondMaxException("【超出发布课题上限】");
        }

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(String subjectName) {
        subjectRepository.deleteById(subjectName);
    }

    @Override
    public Subject updateScore(String subjectName, String score) {
        student = studentRepository.findBySelectedSubject(subjectName);
        student.setScore(score);
        studentRepository.save(student);

        subject = subjectRepository.findByName(subjectName);
        subject.setScore(score);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject agreeSelect(String subjectName, String teacherIsAgree) {
        Boolean teacherIsAgreeBoolean = false;
        if (teacherIsAgree.equals("true")) {
            teacherIsAgreeBoolean = true;
        }
        student = studentRepository.findBySelectedSubject(subjectName);
        student.setTeacherIsAgree(teacherIsAgreeBoolean);
        studentRepository.save(student);

        subject = subjectRepository.findByName(subjectName);
        subject.setTeacherIsAgree(teacherIsAgreeBoolean);
        return subjectRepository.save(subject);
    }

    @Override
    public SubjectListResponse getSubject(String teacherName) {
        return new SubjectListResponse(subjectRepository.findAllByWhoCreate(teacherName));
    }
}
