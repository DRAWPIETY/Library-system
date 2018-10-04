package com.hcq.book.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String long2String(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		String format = sdf.format(new Date(millis));
		return format;
	}

	public static long string2Long(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		Date parse = sdf.parse(time);
		return parse.getTime();
	}

}
