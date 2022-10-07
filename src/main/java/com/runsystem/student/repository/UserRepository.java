package com.runsystem.student.repository;
import com.runsystem.student.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String name);
    UserEntity findByUserNameAndPassword(String name, String password);
}
