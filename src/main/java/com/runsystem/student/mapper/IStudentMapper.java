package com.runsystem.student.mapper;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.utils.ConvertDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", imports = ConvertDate.class)
public interface IStudentMapper {

//    ConvertDate converDate = Mappers.getMapper(ConvertDate.class);

    StudentEntity toStudentEntity(StudentInput studentInput);

    @Mapping(target = "dateOfBirth", expression = "java(ConvertDate.toLong(entity.getDateOfBirth()))")
    StudentInfoEntity toStudentInfoEntity(StudentInput entity);


}
