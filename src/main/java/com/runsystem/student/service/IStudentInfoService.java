package com.runsystem.student.service;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.dto.StudentInfoDTO;

import java.util.List;

public interface IStudentInfoService {
    StudentInfoDTO saveStudentInfo(StudentInput studentInfoInput);
    List<StudentInfoDTO> searchStudentByInfo(StudentInput student);

    void deleteByStudentID(Long id);
    List<StudentInfoDTO> getListStudent();
}
