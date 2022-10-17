package com.runsystem.student.converter;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.utils.ConvertDate;
import org.springframework.stereotype.Component;

@Component
public class StudentInputConverter {
    ConvertDate convertDate;

    public StudentEntity toStudentEntity(StudentInput input) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(input.getStudentId());
        studentEntity.setStudentCode(input.getStudentCode());
        studentEntity.setStudentName(input.getStudentName());
        return studentEntity;
    }

    public StudentInfoEntity toStudentInfoEntity(StudentInput input) {
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();

        studentInfoEntity.setAddress(input.getAddress());
        studentInfoEntity.setAverageScore(input.getAverageScore());
        studentInfoEntity.setDateOfBirth(convertDate.toLong(input.getDateOfBirth()));

        return studentInfoEntity;
    }
}
