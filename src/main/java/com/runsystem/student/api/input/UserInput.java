package com.runsystem.student.api.input;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserInput {

    @NotNull(message = "Username cannot be null")
    private String userName;

    @NotNull(message = "PassWord cannot be null")
    @Size(min = 6, max = 15, message = "Password be between 6 and 15 characters")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
