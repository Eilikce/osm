package com.eilikce.osm.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(DateFormatUtil.class);
	
	/**
	 * 时间戳对象根据格式转换为字符串时间
	 * @param timestamp
	 * @param format
	 * @return
	 */
	public static String TimestampToString(Timestamp timestamp, String format) {
		String timeString = "";
		if ("".equals(format) || null == format) {
			LOG.error("时间转换失败");
			return timeString;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		timeString = sdf.format(timestamp);

		return timeString;
	}

	/**
	 * 时间戳对象根据格式转换为字符串时间
	 * @param timeString
	 * @param format
	 * @return
	 */
	public static Timestamp StringToTimestamp(String timeString, String format) {
		Timestamp timestamp = null;
		if ("".equals(format) || null == format) {
			LOG.error("时间转换失败，格式串错误");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			timestamp = (Timestamp) sdf.parse(timeString);
		} catch (ParseException e) {
			LOG.error("时间转换失败");
			e.printStackTrace();
		}
		
		return timestamp;
	}
}
