package com.runsystem.student.service.impl;

import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.api.input.UserRegisterInput;
import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.entity.RoleEntity;
import com.runsystem.student.entity.UserEntity;
import com.runsystem.student.mapper.IUserMapper;
import com.runsystem.student.repository.RoleRepository;
import com.runsystem.student.repository.UserRepository;
import com.runsystem.student.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    IUserMapper userMapper;

    // Check user dang ky da ton tai chua
    private Boolean isUserByUserName(String name)
    {
        UserEntity userEntity = userRepository.findByUserName(name);
        if (userEntity != null) {
            return true;
        }
        return false;
    }

    // Them user moi vao data
    @Override
    public UserDTO registerUser(UserRegisterInput user) {
        if (isUserByUserName(user.getUserName())) {
            return null;
        } else {
            // Lưu User vào DB và trả user mới thêm về cho client
            UserEntity entity = userMapper.toUserEntity(user);
            return userMapper.toUserDto(userRepository.save(entity));
        }

    }

    // Check login khi dang nhap
    @Override
    public UserDTO checkLogin(UserInput user) {
        UserEntity userEntity = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassWord());

        if (userEntity != null) {
            return userMapper.toUserDto(userEntity);
        }
        return null;
    }


//    @Override
//    public UserDTO loadUserByUserName(String userName) {
//        UserEntity userEntity = userRepository.findByUserName(userName);
//
//        if (userEntity != null) {
//            return userMapper.toUserDto(userEntity);
//        }
//        return null;
//    }


    ///
    @Override
    public UserDTO findByUserName(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);

        if (userEntity != null) {
            return userMapper.toUserDto(userEntity);
        }
        return null;
    }

}
