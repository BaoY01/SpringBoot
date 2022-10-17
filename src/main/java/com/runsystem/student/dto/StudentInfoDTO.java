package com.runsystem.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class StudentInfoDTO {
    Long infoId;
    Long studentId;
    String address;
    double averageScore;
    Date dateOfBirth;
    Long classId;
    String studentName;
    String studentCode;
//    StudentDTO studentDTO;

//    public StudentInfoDTO() {
//        studentDTO = new StudentDTO();
//    }

}
