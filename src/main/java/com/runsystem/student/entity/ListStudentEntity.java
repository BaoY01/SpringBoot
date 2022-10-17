package com.runsystem.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ListStudentEntity {
    private Long studentId;
    private String studentCode;
    private String studentName;
    private Long dateOfBirth;
    private String address;
    private double averageScore;
}
