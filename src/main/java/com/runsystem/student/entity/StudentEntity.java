package com.runsystem.student.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classId")
    private ClassEntity aClass;

}
