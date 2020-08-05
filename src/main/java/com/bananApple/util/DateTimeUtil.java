package com.bananApple.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * 公共日期时间工具类
 * 
 * 
 */
public final class DateTimeUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

	/**
	 * 日期格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_FARMAT_ALL = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 日期格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_FARMAT_ALL1 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式：yyyyMMddHHmmss
	 */
	public static final String DATE_FORMAT_SMALL = "yyyyMMddHHmmss";

	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_THIRD = "yyyy-MM-dd";

	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_THIRD1 = "yyyy/MM/dd";

	/**
	 * 默认构造方法 不允许实例化
	 */
	private DateTimeUtil() {

	}

	/**
	 * 将date型日期转换为想要的字符格式 <一句话功能简述> <功能详细描述>
	 *
	 * @param date
	 *            date日期
	 * @param dateFormat
	 *            日期格式：如yyyy-MM-dd HH:mm:ss
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String formatDateToString(Date date, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}

	/**
	 * 将String型日期转换为想要的date型 <一句话功能简述> <功能详细描述>
	 *
	 * @param currentTime
	 *            currentTime
	 * @param dateFormat
	 *            日期格式：如yyyy-MM-dd HH:mm:ss
	 * 
	 * @return Date
	 * @see [类、类#方法、类#成员]
	 */
	public static Date formatStringToDate(String currentTime, String dateFormat) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(dateFormat);

		try {
			date = (Date) df.parseObject(currentTime);
		} catch (ParseException e) {
			logger.error("SimpleDateFormat parse is ERROR", e);
		}

		return date;
	}

	/**
	 * 得到当前格林威治的日期和时间
	 * 
	 * @param dateFormat
	 *            日期格式：如yyyy-MM-dd HH:mm:ss
	 *
	 * @return String
	 */
	public static String getUTCDateTimeNow(String dateFormat) {
		// 取时区
		TimeZone zone = TimeZone.getDefault();

		Calendar c = Calendar.getInstance();

		Date date = new Date();

		// 计算时区偏差
		c.setTimeInMillis(date.getTime() - zone.getOffset(date.getTime()));

		// 格式化
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

		String dateString = formatter.format(c.getTime());

		return dateString;
	}

	/**
	 * 获得当前时间
	 * 
	 * @return "YYYY-MM-DD"
	 */
	public static String getTime() {
		String temp = "yyyy-MM-dd HH:mm";
		SimpleDateFormat formatter = new SimpleDateFormat(temp);
		Date currentTime = new Date();
		return formatter.format(currentTime);
	}

	/**
      * 
      */
	public static String getServerTime() {
		Date date = new Date();
		return formatDateToString(date, DATE_FARMAT_ALL);
	}

	/**
	 * 日期加减
	 * 
	 * @param basicDate
	 * @param n
	 * @return
	 */
	public static Date nDaysAfterOneDate(Date basicDate, double n) {
		long nDay = basicDate.getTime() + (long) (n * 24 * 60 * 60 * 1000);
		basicDate.setTime(nDay);

		return basicDate;
	}

	/**
	 * 日期加减分钟
	 * 
	 * @param basicDate
	 * @param n
	 * @return
	 */
	public static Date dayPlusMini(Date basicDate, int n) {
		long nDay = basicDate.getTime() + (long) (n * 60 * 1000);
		basicDate.setTime(nDay);

		return basicDate;
	}

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Date dd = DateTimeUtil.formatStringToDate("2012-01-12 15:02:51.793",
		// "yyyy-MM-dd HH:mm:ss.Ms");
		//
		// String dateS = DateTimeUtil.formatDateToString(new Date(),
		// DateTimeUtil.DATE_FORMAT_THIRD);
		//
		// System.out.println(dateS);
		// Date dd = new Date();
		// long l = dd.getTime();
		//
		// Date d = nDaysAfterOneDate(new Date(), 0.5);
		// System.out.println(DateTimeUtil.formatDateToString(d,
		// DateTimeUtil.DATE_FORMAT_SMALL));
		//
		// Date t = DateTimeUtil.formatStringToDate("2014-08-01 15:07:58",
		// "yyyy/MM/dd HH:mm:ss");
		// System.out.println(t.getTime());
	}

}
