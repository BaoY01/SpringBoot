package com.runsystem.student.mapper;

import com.runsystem.student.api.input.ClassInput;
import com.runsystem.student.dto.ClassDTO;
import com.runsystem.student.entity.ClassEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClassMapper {

    ClassDTO toClassDto(ClassEntity entity);

    ClassEntity toClassEntity(ClassInput classInput);
}
