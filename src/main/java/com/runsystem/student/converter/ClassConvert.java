package com.runsystem.student.converter;

import com.runsystem.student.dto.ClassDTO;
import com.runsystem.student.entity.ClassEntity;
import org.springframework.stereotype.Component;

@Component
public class ClassConvert {

    public ClassDTO toDTO(ClassEntity entity){
        ClassDTO dto = new ClassDTO();
        dto.setClassId(entity.getClassId());
        dto.setClassName(entity.getClassName());
        dto.setTeacher(entity.getTeacher());
        return dto;
    }
}
