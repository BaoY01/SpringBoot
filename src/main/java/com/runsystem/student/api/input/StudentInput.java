package com.runsystem.student.api.input;

import com.runsystem.student.utils.ConvertDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentInput {
    ConvertDate convertDate;

    @NotNull
    private Long studentId;

    @Size(max = 10, message = "Student code maxlength 10 characters")
    @NotNull
    private String studentCode;

    @NotNull
    @Size(max = 20, message = "Student name maxlength 20 characters")
    private String studentName;

    @NotNull
    private Long classId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotNull
    @Size(max = 225, message = "Student address maxlength 225 characters")
    private String address;

    @NotNull
    @Max(10)
    private double averageScore;

}
