package com.runsystem.student.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id //dinh ngia khoa chinh va not null
    @GeneratedValue(strategy = GenerationType.IDENTITY) //user_id tu dong tang
    private int userId;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 225, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private RoleEntity aRole;
}
