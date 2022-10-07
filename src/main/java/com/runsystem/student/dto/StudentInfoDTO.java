package com.runsystem.student.dto;

import java.time.LocalDate;
import java.util.Date;

public class StudentInfoDTO {
    Long infoId;
    Long studentId;
    String address;
    double avegareScore;
    Date dateOfBirth;

    private StudentDTO studentDTO;

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public StudentInfoDTO() {
        studentDTO = new StudentDTO();
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvegareScore() {
        return avegareScore;
    }

    public void setAvegareScore(double avegareScore) {
        this.avegareScore = avegareScore;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
