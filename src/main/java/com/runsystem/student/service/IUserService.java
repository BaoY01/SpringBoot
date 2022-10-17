package com.runsystem.student.service;

import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.api.input.UserRegisterInput;
import com.runsystem.student.dto.UserDTO;

public interface IUserService {
    UserDTO registerUser(UserRegisterInput user);
    UserDTO checkLogin(UserInput user);
//    UserDTO loadUserByUserName(String userName);

    ///
    UserDTO findByUserName(String userName);
}