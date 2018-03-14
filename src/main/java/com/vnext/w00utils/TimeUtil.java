package com.vnext.w00utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leo
 * @since 2018-02-08 15:41:32
 */
public class TimeUtil {
	//{"startDate":"2018020800","endDate":"2018020823","serviceIds":["InletPressure","OutletPressure"],"deviceIds":["1512016301","1512016302"],"queryType":"day"}
	//{"startDate":"2018020100","endDate":"2018020123","serviceIds":["InletPressure","OutletPressure"],"deviceIds":["16070049"],"queryType":"day"}
	//{"startDate":"20180201","endDate":"20180228","serviceIds":["InletPressure","OutletPressure"],"deviceIds":["16070049"],"queryType":"month"}
	//{"startDate":"201801","endDate":"201812","serviceIds":["InletPressure","OutletPressure"],"deviceIds":["16070049"],"queryType":"year"}
	
	// HOUR  201802020108  -- 分钟数据
	// DAY   2018020100    -- 小时数据
	// MONTH 20180201      -- 日数据
	// YEAR  201801        -- 月数据
	
	private static final SimpleDateFormat TIME_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	private static final DateTimeFormatter HOUR_MAP = DateTimeFormat.forPattern("yyyyMMddHHmm");
    private static final DateTimeFormatter DAY_MAP = DateTimeFormat.forPattern("yyyyMMddHH");
    private static final DateTimeFormatter MONTH_MAP = DateTimeFormat.forPattern("yyyyMMdd");
    private static final DateTimeFormatter YEAR_MAP = DateTimeFormat.forPattern("yyyyMM");

	
	@Test
	public void test01() {
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start = sdf.parse("2018-02-27 23:59:00");
			Date end = sdf.parse("2018-03-01 00:10:00");

			long time = end.getTime();
			long time2 = start.getTime();
			long t = time - time2;
			System.out.println(t/(1000*60));  // 获取时间段的分钟树
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Map<String, DateTimeFormatter> DATE_TYPE_MAP = new HashMap<>(3);

	public static DateTimeFormatter getDateType(String dateType) {
		if (DATE_TYPE_MAP.isEmpty()) {
			DATE_TYPE_MAP.put("hour", HOUR_MAP);
			DATE_TYPE_MAP.put("day", DAY_MAP);
			DATE_TYPE_MAP.put("month", MONTH_MAP);
			DATE_TYPE_MAP.put("year", YEAR_MAP);
		}

		return DATE_TYPE_MAP.getOrDefault(dateType, HOUR_MAP);
	}
	
	public static DateTime plus(String dateType, DateTime dateTime) {
		switch (dateType) {
		case "hour":
			return dateTime.plusMinutes(1);
		case "day":
			return dateTime.plusHours(1);
		case "month":
			return dateTime.plusDays(1);
		case "year":
			return dateTime.plusMonths(1);
		default:
			return dateTime;
		}
	}
	
	public static void main(String[] args) {
		
		DateTime startDateTime = DateTime.parse("201802020108", HOUR_MAP);
		System.out.println(TIME_ALL.format(startDateTime.toDate())); // 2018-02-02 01:08:00
		startDateTime = plus("hour", startDateTime);
		System.out.println(startDateTime.toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTime day = DateTime.parse("2018020105", DAY_MAP);
		System.out.println(day.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(plus("day", day).toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTime month = DateTime.parse("20180201", MONTH_MAP);
		System.out.println(month.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(plus("month", month).toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTime year = DateTime.parse("201802", YEAR_MAP);
		System.out.println(year.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(plus("year", year).toString("yyyy-MM-dd HH:mm:ss"));
		

	}
	
	

}
