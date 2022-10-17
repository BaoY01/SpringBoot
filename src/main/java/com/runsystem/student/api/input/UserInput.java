package com.runsystem.student.api.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserInput {

    @NotNull(message = "Username cannot be null")
    private String userName;

    @NotNull(message = "PassWord cannot be null")
    @Size(min = 6, max = 15, message = "Password be between 6 and 15 characters")
    private String passWord;


}
