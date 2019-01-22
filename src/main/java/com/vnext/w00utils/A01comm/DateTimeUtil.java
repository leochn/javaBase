package com.vnext.w00utils.A01comm;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: LEO
 * @Date: 2018/11/25 20:13
 * @Description:
 */
public class DateTimeUtil {

    private static final DateTimeFormatter DAY_MAP = DateTimeFormat.forPattern("yyyyMMdd");
    private static final DateTimeFormatter MONTH_MAP = DateTimeFormat.forPattern("yyyyMM");
    private static final DateTimeFormatter YEAR_MAP = DateTimeFormat.forPattern("yyyy");

    private static Map<String, DateTimeFormatter> DATE_TYPE_MAP = new HashMap<>(4);

    public static DateTimeFormatter getDateType(String dateType) {
        if (DATE_TYPE_MAP.isEmpty()) {
            DATE_TYPE_MAP.put("day", DAY_MAP);
            DATE_TYPE_MAP.put("month", MONTH_MAP);
            DATE_TYPE_MAP.put("year", YEAR_MAP);
        }
        return DATE_TYPE_MAP.getOrDefault(dateType, DATE_TYPE_MAP.get(dateType));
    }


    public static DateTime plusTime (String dateType, DateTime dateTime,int count) {
        switch (dateType) {
            case "day":
                return dateTime.plusDays(count);
            case "month":
                return dateTime.plusMonths(count);
            case "year":
                return dateTime.plusYears(count);
            default:
                return dateTime;
        }
    }

    public static DateTime minusTime(String dateType, DateTime dateTime,int count) {
        switch (dateType) {
            case "day":
                return dateTime.minusDays(count);
            case "month":
                return dateTime.minusMonths(count);
            case "year":
                return dateTime.minusYears(count);
            default:
                return dateTime;
        }
    }

    // 获取时间
    public static DateTime getTime(String dateType, String formatTime){
        DateTimeFormatter format = getDateType(dateType);
        DateTime dateTime = DateTime.parse(formatTime, format);
        return dateTime;
    }

    public static void main(String[] args) {
        String time = "20180101";
        DateTime day = getTime("day", time);
        String a = "";
    }

}