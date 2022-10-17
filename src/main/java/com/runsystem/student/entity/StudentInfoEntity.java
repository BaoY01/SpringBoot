package com.runsystem.student.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
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
}
