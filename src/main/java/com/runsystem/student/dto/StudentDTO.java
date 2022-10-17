package com.runsystem.student.dto;

import com.runsystem.student.entity.ClassEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    Long studentId;
    String studentName;
    String studentCode;
    Long classId;
}
