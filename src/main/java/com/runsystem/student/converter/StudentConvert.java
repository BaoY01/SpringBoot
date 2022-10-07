package com.runsystem.student.converter;

import com.runsystem.student.dto.StudentDTO;
import com.runsystem.student.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConvert {

    public StudentEntity toEntity(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();

        entity.setStudentId(dto.getStudentId());
        entity.setStudentCode(dto.getStudentCode());
        entity.setStudentName(dto.getStudentName());


        return entity;
    }

    public StudentDTO toDTO(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();

        dto.setStudentId(entity.getStudentId());
        dto.setStudentCode(entity.getStudentCode());
        dto.setStudentName(entity.getStudentName());


        return dto;
    }
}
