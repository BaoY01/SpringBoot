package com.runsystem.student.repository;

import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import com.runsystem.student.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudentId(Long id);
}
