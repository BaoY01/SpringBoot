package com.runsystem.student.converter;

import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

}
