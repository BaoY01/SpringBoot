package com.runsystem.student.repository;

import com.runsystem.student.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassName(String className);
    ClassEntity findOneByClassId(Long classId);

}
