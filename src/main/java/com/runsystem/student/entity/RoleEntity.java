package com.runsystem.student.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roloId;

    @Column
    private String roleName;

    @Column
    private String roleCode;

    @OneToMany(mappedBy = "aRole")
    private List<UserEntity> userEntities = new ArrayList<>();
}
