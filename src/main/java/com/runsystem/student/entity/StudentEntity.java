package com.runsystem.student.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id //dinh nghia khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY)//student_di tu dong tang
    private Long studentId;

    @Column(length = 20, nullable = false)
    private String studentName;

    @Column(length = 10, nullable = false)
    private String studentCode;

    @OneToOne(mappedBy = "student")
    private StudentInfoEntity studentInfo;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public StudentInfoEntity getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfoEntity studentInfo) {
        this.studentInfo = studentInfo;
    }
}
