package com.runsystem.student.service.impl;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.converter.StudentConvert;
import com.runsystem.student.converter.StudentInfoConverter;
import com.runsystem.student.dto.StudentDTO;
import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.UserEntity;
import com.runsystem.student.repository.StudentRepository;
import com.runsystem.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    public Boolean isStudentId(Long id)
    {
        StudentEntity studentEntity = studentRepository.findByStudentId(id);
        if (studentEntity != null) {
            return true;
        }
        return false;
    }
}
