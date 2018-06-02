package com.df.xkxtbackend.service;

import com.df.xkxtbackend.domain.entity.Student;
import com.df.xkxtbackend.domain.entity.Subject;
import com.df.xkxtbackend.domain.model.StudentLog;
import com.df.xkxtbackend.domain.request.StudentLogRequest;
import com.df.xkxtbackend.domain.response.SubjectListResponse;
import com.df.xkxtbackend.exception.IllegalParameterException;
import com.df.xkxtbackend.repository.StudentRepository;
import com.df.xkxtbackend.repository.SubjectRepository;
import com.df.xkxtbackend.util.MD5EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Student student;

    @Autowired
    private Subject subject;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Student login(String studyNumber, String password) {
        // 判断用户是否存在
        if (studentRepository.findByStudyNumber(studyNumber) == null) {
            throw new IllegalParameterException("【学生用户不存在】");
        }

        // 密码是否正确
        if (!studentRepository.findByStudyNumber(studyNumber).getPassword().equals(MD5EncodeUtil.encode(password))) {
            throw new IllegalParameterException("【密码错误】");
        }

        return studentRepository.findByStudyNumber(studyNumber);
    }

    @Override
    public Student changePassword(String studyNumber, String oldPassword, String newPassword) {
        // 判断原密码是否正确
        if (!studentRepository.findByStudyNumber(studyNumber).getPassword().equals(MD5EncodeUtil.encode(oldPassword))) {
            throw new IllegalParameterException("【原密码错误】");
        }

        student = studentRepository.findByStudyNumber(studyNumber);
        student.setPassword(MD5EncodeUtil.encode(newPassword));
        return studentRepository.save(student);
    }

    @Override
    public Subject selectSubject(String studyNumber, String subjectName) {
        // 更新学生表
        student = studentRepository.findByStudyNumber(studyNumber);
        student.setSelectedSubject(subjectName);
        studentRepository.save(student);

        // 更新课题表
        subject = subjectRepository.findByName(subjectName);
        subject.setSelectBy(student.getName());
        subjectRepository.save(subject);

        return subject;
    }

    @Override
    public Subject changeSelectedSubject(String studyNumber, String oldSubjectName, String newSubjectName) {
        // 更新学生表
        student = studentRepository.findByStudyNumber(studyNumber);
        student.setSelectedSubject(newSubjectName);
        studentRepository.save(student);

        // 更新课题表
        subject = subjectRepository.findByName(oldSubjectName);
        subject.setSelectBy(null);
        subjectRepository.save(subject);
        subject = subjectRepository.findByName(newSubjectName);
        subject.setSelectBy(student.getName());
        return subjectRepository.save(subject);
    }

    @Override
    public SubjectListResponse getSubject() {
        return new SubjectListResponse(subjectRepository.findAllByAdminIsPassAndSelectBy(true, null));
    }

    @Override
    public Student pushLog(StudentLogRequest studentLogRequest) {
        student = studentRepository.findByStudyNumber(studentLogRequest.getStudyNumber());
        List<StudentLog> tempStudentLogs;
        if (student.getStudentLogs() != null) {
            tempStudentLogs = new ArrayList<>(Arrays.asList(student.getStudentLogs()));
        } else {
            tempStudentLogs = new ArrayList<>();
        }
        tempStudentLogs.add(studentLogRequest.getStudentLog());
//        StudentLog[] studentLogs = (StudentLog[]) tempStudentLogs.toArray();
        StudentLog[] studentLogs = new StudentLog[tempStudentLogs.size()];
        for (int i = 0; i < tempStudentLogs.size(); i++) {
            studentLogs[i] = tempStudentLogs.get(i);
        }

//        StudentLog[] studentLogs = student.getStudentLogs();
//        studentLogs[studentLogs.length] = studentLogRequest.getStudentLog();
        student.setStudentLogs(studentLogs);
        return studentRepository.save(student);
    }

    @Override
    public StudentLog[] getLogs(String name) {
        return studentRepository.findByName(name).getStudentLogs();
    }
}
