package com.runsystem.student.entity;

import java.util.Date;

public class ListStudentEntity {
    private Long studentId;
    private String studentCode;
    private String studentName;
    private Long dateOfBirth;
    private String address;
    private double averageScore;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public ListStudentEntity(Long studentId, String studentCode, String studentName, Long dateOfBirth, String address, double averageScore) {
        this.studentId = studentId;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.averageScore = averageScore;
    }
}
