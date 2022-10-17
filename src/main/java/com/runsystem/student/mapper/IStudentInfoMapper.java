package com.runsystem.student.mapper;

import com.runsystem.student.dto.StudentInfoDTO;
import com.runsystem.student.entity.ListStudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.utils.ConvertDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = ConvertDate.class)
public interface IStudentInfoMapper {

    @Mapping(target = "studentId", expression = "java(entity.getStudent().getStudentId())")
    @Mapping(target = "studentName", expression = "java(entity.getStudent().getStudentName())")
    @Mapping(target = "studentCode", expression = "java(entity.getStudent().getStudentCode())")
    @Mapping(target = "classId", expression = "java(entity.getStudent().getAClass().getClassId())")
    @Mapping(target = "dateOfBirth", expression = "java(ConvertDate.toDate(entity.getDateOfBirth()))")
    StudentInfoDTO toDTO(StudentInfoEntity entity);


    @Mapping(target = "dateOfBirth", expression = "java(ConvertDate.toDate(entity.getDateOfBirth()))")
    StudentInfoDTO toDTO(ListStudentEntity entity);
}
