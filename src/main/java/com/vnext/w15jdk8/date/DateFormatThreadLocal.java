package com.vnext.w15jdk8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 22:21:10
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }

    };

    public static final Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}