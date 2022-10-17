package com.runsystem.student.mapper;

import com.runsystem.student.api.input.UserRegisterInput;
import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity toUserEntity(UserRegisterInput registerInput);
    UserDTO toUserDto(UserEntity entity);

}
