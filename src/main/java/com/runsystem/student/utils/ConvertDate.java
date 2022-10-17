package com.runsystem.student.utils;

import java.util.Date;
public class ConvertDate {

    public static Date toDate( Long date) {
        return new Date(date);
    }

    public static Long toLong(Date date) {
        return date.getTime();
    }

}
