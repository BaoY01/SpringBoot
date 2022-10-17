package com.runsystem.student.api.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRegisterInput {
    @NotNull(message = "UserName cannot be null")
    private String userName;

    @NotNull(message = "PassWord cannot be null")
    @Size(min = 6, max = 15, message = "Password be between 6 and 15 characters")
    private String password;

    @NotNull(message = "PassWord Confirm cannot be null")
    @Size(min = 6, max = 15, message = "Password Confirm be between 6 and 15 characters")
    private String passWordConfirm;

}
