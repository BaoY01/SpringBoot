package com.runsystem.student.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studentinfo")
public class StudentInfoEntity {

    @Id//khoa chinh not null
    @GeneratedValue(strategy = GenerationType.IDENTITY)//info_id tu dong tang
    private Long infoId;

    @Column(length = 255)
    private String address;

    @Column
    private double averageScore;

    @Column
    private Long dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private StudentEntity student;


    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
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

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
