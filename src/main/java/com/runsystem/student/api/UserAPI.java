package com.runsystem.student.api;

import com.runsystem.student.api.input.UserInput;
import com.runsystem.student.api.input.UserRegisterInput;
import com.runsystem.student.api.output.DataResponse;
import com.runsystem.student.constant.ConstantSystem;
import com.runsystem.student.dto.UserDTO;
import com.runsystem.student.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
public class UserAPI {
    @Autowired
    private IUserService userService;

    ConstantSystem constantSystem;

    @SuppressWarnings("static-access")
    @PostMapping(value = "/login")
    public DataResponse<UserDTO> login(HttpServletRequest request, @Valid @RequestBody UserInput user) {
        String result = "";
        UserDTO dto = null;
        try {
            //BẬT đăng nhập vào hệ thống
            dto = userService.checkLogin(user);
            if (dto != null) {
                result = constantSystem.TOKEN_SUCCESS;
            } else {
                result = constantSystem.WRONG_USERNAME_PASSWORD;
            }
        } catch (Exception ex) {
            result = constantSystem.SERVER_ERROR;
        }
        return new DataResponse<UserDTO>(result, dto, LocalDateTime.now().toString());
    }


    @SuppressWarnings("static-access")
    @PostMapping(value = "/register")
    public DataResponse<UserDTO> register(HttpServletRequest request, @Valid @RequestBody UserRegisterInput user) {

        // Check password confirm and password
        if (!user.getPassWord().equals(user.getPassWordConfirm())) {
            return new DataResponse<UserDTO>(constantSystem.PASSWORD_PASSWORKCONFIRM, null,
                    LocalDateTime.now().toString());
        }

        String result = "";
        UserDTO dto = null;
        try {
            // perform user registration and check if the user already exists.
            dto = userService.registerUser(user);
            if (dto != null) {
                result = constantSystem.REGISTER_SUCCESS;
            } else {
                result = constantSystem.ACCOUNT_ALREADY;
            }
        } catch (Exception ex) {
            result = constantSystem.SERVER_ERROR;
        }
        return new DataResponse<UserDTO>(result, dto, LocalDateTime.now().toString());
    }


}
