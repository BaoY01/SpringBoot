package com.runsystem.student.api;

import com.runsystem.student.api.input.ClassInput;
import com.runsystem.student.api.output.DataResponse;
import com.runsystem.student.constant.ConstantSystem;
import com.runsystem.student.dto.ClassDTO;
import com.runsystem.student.service.impl.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
public class ClassAPI {

    @Autowired
    ClassService classService;

    ConstantSystem constantSystem;

    @PostMapping(value = "/class")
    public DataResponse<ClassDTO> register(HttpServletRequest request, @Valid @RequestBody ClassInput classInput) {
        String result = "";
        ClassDTO dto = null;
        try {
            // perform user registration and check if the class already exists.
            dto = classService.rigisterClass(classInput);
            if (dto != null) {
                result = constantSystem.REGISTER_SUCCESS;
            } else {
                result = constantSystem.CLASS_ALREADY;
            }
        } catch (Exception ex) {
            result = constantSystem.SERVER_ERROR;
        }
        return new DataResponse<ClassDTO>(result, dto, LocalDateTime.now().toString());
    }
}
