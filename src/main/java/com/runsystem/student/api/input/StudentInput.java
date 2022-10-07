package com.runsystem.student.api.input;

import com.runsystem.student.utils.ConvertDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotNull
    @Size(max = 225, message = "Student address maxlength 225 characters")
    private String address;

    @NotNull
    @Max(10)
    private Double averageScore;

    public ConvertDate getConvertDate() {
        return convertDate;
    }

    public void setConvertDate(ConvertDate convertDate) {
        this.convertDate = convertDate;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
