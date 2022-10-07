package com.runsystem.student.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id //dinh ngia khoa chinh va not null
    @GeneratedValue(strategy = GenerationType.IDENTITY) //user_id tu dong tang
    private int userId;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 15, nullable = false)
    private String password;

    public int getUser_id() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
