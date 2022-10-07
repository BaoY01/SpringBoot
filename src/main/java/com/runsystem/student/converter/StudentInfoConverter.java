package com.runsystem.student.converter;

import com.runsystem.student.dto.StudentInfoDTO;
import com.runsystem.student.entity.ListStudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.utils.ConvertDate;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoConverter {

    ConvertDate convertDate;

    public StudentInfoEntity toEntity(StudentInfoDTO dto) {
        StudentInfoEntity entity = new StudentInfoEntity();

        entity.setInfoId(dto.getInfoId());
        entity.setAddress(dto.getAddress());
        entity.setAverageScore(dto.getAvegareScore());

//		Convert Long to data set for Entity;
        entity.setDateOfBirth(convertDate.toLong(dto.getDateOfBirth()));
        return entity;
    }

    public StudentInfoDTO toDTO(StudentInfoEntity entity) {
        StudentInfoDTO dto = new StudentInfoDTO();

//		Convert StudentInfoEntity to StudentInfoDTO
        dto.setInfoId(entity.getInfoId());
        dto.setStudentId(entity.getStudent().getStudentId());
        dto.setAddress(entity.getAddress());
        dto.setAvegareScore(entity.getAverageScore());

//		Convert Long to Date set for DTO;
        dto.setDateOfBirth(convertDate.toDate(entity.getDateOfBirth()));

//        Convert StudentEntity to StudentDTO
        dto.getStudentDTO().setStudentCode(entity.getStudent().getStudentCode());
        dto.getStudentDTO().setStudentName(entity.getStudent().getStudentName());
        dto.getStudentDTO().setStudentId(entity.getStudent().getStudentId());


        return dto;
    }

    ///search ListStudentEntity
    public StudentInfoDTO toDTO(ListStudentEntity entity) {
        StudentInfoDTO dto = new StudentInfoDTO();

//		Convert StudentInfoEntity to StudentInfoDTO
        dto.setStudentId(entity.getStudentId());
        dto.setAddress(entity.getAddress());
        dto.setAvegareScore(entity.getAverageScore());

//		Convert Long to Date set for DTO;
        dto.setDateOfBirth(convertDate.toDate(entity.getDateOfBirth()));

//      Convert StudentEntity to StudentDTO
        dto.getStudentDTO().setStudentCode(entity.getStudentCode());
        dto.getStudentDTO().setStudentName(entity.getStudentName());
        dto.getStudentDTO().setStudentId(entity.getStudentId());

        return dto;
    }

}
