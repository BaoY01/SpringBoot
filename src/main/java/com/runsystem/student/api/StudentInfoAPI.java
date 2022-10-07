package com.runsystem.student.api;

import com.runsystem.student.api.input.StudentInput;
import com.runsystem.student.api.output.DataResponse;
import com.runsystem.student.constant.ConstantSystem;
import com.runsystem.student.dto.StudentInfoDTO;
import com.runsystem.student.service.IStudentInfoService;
import com.runsystem.student.service.impl.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api")
public class StudentInfoAPI {

    @Autowired
    private IStudentInfoService studentInfoService;

    @Autowired
    StudentService studentService;

    ConstantSystem constantSystem;


    @PutMapping(value = "/students")
    public DataResponse<StudentInfoDTO> updateStudent(@RequestBody StudentInput student) {
        StudentInfoDTO studentDTO = studentInfoService.saveStudentInfo(student);
        return new DataResponse<StudentInfoDTO>(constantSystem.SUCCESS, studentDTO, LocalDateTime.now().toString());
    }


    @PostMapping(value = "/students")
    public DataResponse<StudentInfoDTO> saveStudent(@RequestBody StudentInput student) {
        StudentInfoDTO studentDTO = studentInfoService.saveStudentInfo(student);
        return new DataResponse<StudentInfoDTO>(constantSystem.SUCCESS, studentDTO, LocalDateTime.now().toString());
    }

    @GetMapping(value = "/students")
    public DataResponse<List<StudentInfoDTO>> getAll(@RequestBody StudentInput student) {

        StudentInput studentSearchInput = new StudentInput();

//		isNotBlank = (null) and (isEmpty)
        studentSearchInput.setStudentCode(StringUtils.isNotBlank(student.getStudentCode()) ? student.getStudentCode() : null);
        studentSearchInput.setStudentName(StringUtils.isNotBlank(student.getStudentName()) ? student.getStudentName() : null);
        studentSearchInput.setBirthDay(student.getBirthDay());

//		Query by field
        List<StudentInfoDTO> studentDTOs = studentInfoService.searchStudentByInfo(studentSearchInput);

        return new DataResponse<List<StudentInfoDTO>>(constantSystem.SUCCESS, studentDTOs,
                LocalDateTime.now().toString());
    }


    @DeleteMapping(value = "students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        String result = "";
        if(studentService.isStudentId(id)){
            studentInfoService.deleteByStudentID(id);
            result = constantSystem.SUCCESS;
        }else{
            result = constantSystem.STUDENT_NOT_FIND;
        }
        return result;
    }

    @GetMapping(value = "students/show")
    public DataResponse<List<StudentInfoDTO>> getShowList() {

//		Query by field
        List<StudentInfoDTO> studentDTOs = studentInfoService.getListStudent();

        return new DataResponse<List<StudentInfoDTO>>(constantSystem.SUCCESS, studentDTOs,
                LocalDateTime.now().toString());
    }
}
