package com.runsystem.student.service.impl;

import com.runsystem.student.entity.ClassEntity;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.repository.ClassRepository;
import com.runsystem.student.repository.StudentRepository;
import com.runsystem.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    public Boolean isStudentId(Long id)
    {
        StudentEntity studentEntity = studentRepository.findByStudentId(id);
        if (studentEntity != null) {
            return true;
        }
        return false;
    }

    // Check class da ton tai chua
    public Boolean isClassByClassId(Long classId)
    {
        ClassEntity classEntity = classRepository.findOneByClassId(classId);
        if (classEntity != null) {
            return true;
        }
        return false;
    }
}
