package com.runsystem.student.api.output;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> {
    private String errorMessage;
    private T data;
    private String dateTime;

}
