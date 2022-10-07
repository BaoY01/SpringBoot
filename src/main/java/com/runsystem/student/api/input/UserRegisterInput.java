package com.runsystem.student.api.input;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
public class UserRegisterInput {
    @NotNull(message = "UserName cannot be null")
    private String userName;

    @NotNull(message = "PassWord cannot be null")
    @Size(min = 6, max = 15, message = "Password be between 6 and 15 characters")
    private String passWord;

    @NotNull(message = "PassWord Confirm cannot be null")
    @Size(min = 6, max = 15, message = "Password Confirm be between 6 and 15 characters")
    private String passWordConfirm;

    public String getPassWordConfirm() {
        return passWordConfirm;
    }

    public void setPassWordConfirm(String passWordConfirm) {
        this.passWordConfirm = passWordConfirm;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
