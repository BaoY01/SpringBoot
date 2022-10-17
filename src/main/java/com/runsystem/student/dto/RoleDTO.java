package com.runsystem.student.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoleDTO {

    private Long roleId;
    private String roleName;
    private String roleCode;

    private List<UserDTO> userEntities = new ArrayList<>();
}
