package com.runsystem.student.service;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.dto.StudentDTO;
import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.entity.StudentEntity;

public interface IStudentService {
    Boolean isStudentId(Long id);
}
