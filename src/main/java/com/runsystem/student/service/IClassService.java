package com.runsystem.student.service;

import com.runsystem.student.api.input.ClassInput;
import com.runsystem.student.dto.ClassDTO;

public interface IClassService {
    ClassDTO rigisterClass(ClassInput classInput);

}
