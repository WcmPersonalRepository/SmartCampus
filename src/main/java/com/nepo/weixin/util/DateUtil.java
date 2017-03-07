package com.nepo.weixin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String FORMAT_0 = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_1 = "yyyy-MM-dd";
	private static final String FORMAT_2 = "HH:mm:ss";
	private static final String FORMAT_3 = "yyyy年MM月dd日";

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期时间，精确到秒 如:2010-4-15 9:36:38
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 * **/
	public static String toFull(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_0);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期 如:2010-4-15
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 * **/
	public static String toDate(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_1);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}
	public static String toDate3(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_3);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	 public static String getWeekOfDate(Date dt) {
	        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(dt);
	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0)
	            w = 0;
	        return weekDays[w];
	    }
	/**
	 * 如果参数长度不为为0,则取第一个参数进行格式化，<br>
	 * 否则取当前日期时间，精确到秒<br>
	 * 如:9:36:38
	 * 
	 * @param Date
	 *            ... 可变参数
	 * @return java.lang.String
	 * **/
	public static String toTime(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_2);
		if (date.length > 0) {
			return simple.format(date[0]);
		}
		return simple.format(new Date());
	}

	/**
	 * 根据字符串格式去转换相应格式的日期和时间
	 * 
	 * @param java
	 *            .lang.String 必要参数
	 * @return java.util.Date
	 * @exception java.text.ParseException
	 *                如果参数格式不正确会抛出此异常
	 * **/
	public static Date reverse2Date(String date) {
		SimpleDateFormat simple = null;
		switch (date.trim().length()) {
		case 19:// 日期+时间
			simple = new SimpleDateFormat(FORMAT_0);
			break;
		case 10:// 仅日期
			simple = new SimpleDateFormat(FORMAT_1);
			break;
		case 8:// 仅时间
			simple = new SimpleDateFormat(FORMAT_2);
			break;
		default:
			break;
		}
		try {
			return simple.parse(date.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date reverse2Date_Date(String date) {
		SimpleDateFormat simple = null;
		simple = new SimpleDateFormat(FORMAT_1);
		try {
			return simple.parse(date.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将带有时、分、秒格式的日期转化为00:00:00<br>
	 * 方便日期推算,格式化后的是yyyy-MM-dd 00:00:00
	 * 
	 * @param java
	 *            .util.Date... date的长度可以为0,即不用给参数
	 * @return java.util.Date
	 * **/
	public static Date startOfADay(Date... date) {
		SimpleDateFormat simple = new SimpleDateFormat(FORMAT_1);
		Date date_ = date.length == 0 ? new Date() : date[0];// 如果date为null则取当前时间
		String d = simple.format(date_);
		try {
			return simple.parse(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 推算一个月内向前或向后偏移多少天,当然推算年也可以使用
	 * 
	 * @param date
	 *            要被偏移的日期,<br>
	 *            amout 偏移量<br>
	 *            b 是否先将date格式化为yyyy-MM-dd 00:00:00 即: 是否严格按整天计算
	 * @return java.util.Date
	 * **/
	public static Date addDayOfMonth(Date date, Integer amount, Boolean b) {
		date = date == null ? new Date() : date;// 如果date为null则取当前日期
		if (b) {
			date = startOfADay(date);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * 推算一个小时内向前或向后偏移多少分钟,除了秒、毫秒不可以以外,其他都可以
	 * 
	 * @param date
	 *            要被偏移的日期,<br>
	 *            amout 偏移量<br>
	 *            b 是否先将date格式化为yyyy-MM-dd HH:mm:00 即: 是否严格按整分钟计算
	 * @return java.util.Date
	 * **/
	public static Date addMinuteOfHour(Date date, Integer amount, Boolean b) {
		date = date == null ? new Date() : date;// 如果date为null则取当前日期
		if (b) {
			SimpleDateFormat simple = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:00");
			try {
				date = simple.parse(simple.format(date));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, amount);
		return cal.getTime();
	}

	public static String[] weekName = { "周日", "周一", "周二", "周三", "周四", "周五",
			"周六" };

	public static int getMonthDays(int year, int month) {
		if (month > 12) {
			month = 1;
			year += 1;
		} else if (month < 1) {
			month = 12;
			year -= 1;
		}
		int[] arr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int days = 0;

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			arr[1] = 29; // 闰年2月29天
		}

		try {
			days = arr[month - 1];
		} catch (Exception e) {
			e.getStackTrace();
		}

		return days;
	}

	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	public static int getCurrentMonthDay() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	public static int getWeekDay() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

	public static int getHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute() {
		return Calendar.getInstance().get(Calendar.MINUTE);
	}

	public static int getSecond() {
		return Calendar.getInstance().get(Calendar.SECOND);
	}

	public static int[] getWeekSunday(int year, int month, int day, int pervious) {
		int[] time = new int[3];
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.add(Calendar.DAY_OF_MONTH, pervious);
		time[0] = c.get(Calendar.YEAR);
		time[1] = c.get(Calendar.MONTH) + 1;
		time[2] = c.get(Calendar.DAY_OF_MONTH);
		return time;

	}

	public static int getWeekDayFromDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDateFromString(year, month));
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return week_index;
	}

	public static Date getDateFromString(int year, int month) {
		String dateString = year + "-" + (month > 9 ? month : ("0" + month))
				+ "-01";
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(dateString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.addMinuteOfHour(new Date(), 60, false));
	}

	/**
	 * 对比时间 时间1大于时间2返回ture
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx秒
	 */
	public static boolean isCompareDate(Date date1, Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if (time1 - time2 >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 2个时间相隔的秒数
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为xx秒
	 */
	public static long getDistanceTimeToSec(Date date1, Date date2) {
		long sec = 0;
		try {
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			sec = (diff / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sec;
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx秒
	 */
	public static long getDistanceTimeToYear(Date date1, Date date2) {
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day / 365;
	}
}
