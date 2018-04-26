package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.Student;
import com.df.xkxtbackend.exception.IllegalParameterException;
import com.df.xkxtbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student login(String studyNumber, String password) {
        // 判断用户是否存在
        if (studentRepository.findByStudyNumber(studyNumber) == null) {
            throw new IllegalParameterException("【用户不存在】");
        }

        // 密码是否正确
        if (!studentRepository.findByStudyNumber(studyNumber).getPassword().equals(password)) {
            throw new IllegalParameterException("【密码错误】");
        }
        
        return studentRepository.findByStudyNumber(studyNumber);
    }
}
