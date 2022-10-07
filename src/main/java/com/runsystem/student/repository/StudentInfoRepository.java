package com.runsystem.student.repository;

import com.runsystem.student.entity.ListStudentEntity;
import com.runsystem.student.entity.StudentEntity;
import com.runsystem.student.entity.StudentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface StudentInfoRepository extends JpaRepository<StudentInfoEntity, Long> {
    List<StudentInfoEntity> findByStudent(StudentEntity studentEntity);

    @Query("SELECT new com.runsystem.student.entity.ListStudentEntity("
                  + "s1.studentId, "
                  + "s1.studentCode, "
                  + "s1.studentName, "
                  + "s2.dateOfBirth, "
                  + "s2.address, "
                  + "s2.averageScore) "
                  + "FROM StudentEntity s1, StudentInfoEntity s2 "
                  + "WHERE s2.student.studentId = s1.studentId"
    )
    public List<ListStudentEntity> findAllListStudent();

    @Query("SELECT new com.runsystem.student.entity.ListStudentEntity("
            + "s1.studentId, "
            + "s1.studentCode, "
            + "s1.studentName, "
            + "s2.dateOfBirth, "
            + "s2.address, "
            + "s2.averageScore) "
            + "FROM StudentEntity s1, StudentInfoEntity s2 "
            + "WHERE s1.studentId = s2.student.studentId AND (s1.studentCode LIKE %?1% OR s1.studentName LIKE %?2% OR s2.dateOfBirth = ?3)"
    )
    List<ListStudentEntity> searchListStudent(String studentCode, String studentName, Long dateOfBirth);

}
