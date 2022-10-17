package com.runsystem.student.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long classId;

    @Column(length = 50, nullable = false)
    String className;

    @Column(length = 50, nullable = false)
    String teacher;

    @OneToMany(mappedBy = "aClass")
    private List<StudentEntity> students = new ArrayList<>();

}
