package com.runsystem.student.service.impl;

import com.runsystem.student.api.input.ClassInput;

import com.runsystem.student.dto.ClassDTO;
import com.runsystem.student.entity.ClassEntity;
import com.runsystem.student.mapper.IClassMapper;
import com.runsystem.student.repository.ClassRepository;
import com.runsystem.student.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService implements IClassService {

    @Autowired
    ClassRepository classRepository;

//    @Autowired
//    ClassConvert classConvert;

    @Autowired
    IClassMapper classMapper;

    // Check class da ton tai chua
    private Boolean isClassByClassName(String name)
    {
        ClassEntity classEntity = classRepository.findByClassName(name);
        if (classEntity != null) {
            return true;
        }
        return false;
    }

    // Them class moi vao data
    @Override
    public ClassDTO rigisterClass(ClassInput classInput) {
        if (isClassByClassName(classInput.getClassName())) {
            return null;
        } else {
            // Lưu class vào DB và trả class mới thêm về cho client
            ClassEntity entity = classMapper.toClassEntity(classInput);
            return classMapper.toClassDto(classRepository.save(entity));
        }
    }
}
