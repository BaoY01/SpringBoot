package com.runsystem.student.api.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClassInput {

    @NotNull(message = "ClassName cannot be null")
    private String className;

    @NotNull(message = "Teacher cannot be null")
    private String teacher;

}
