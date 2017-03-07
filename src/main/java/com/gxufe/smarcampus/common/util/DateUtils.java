package com.gxufe.smarcampus.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtils {

    public static final long HOUR_MILLSECONDS = 3600 * 1000;

    public static final long DAY_MILLSECONDS = 24 * HOUR_MILLSECONDS;

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_0 = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd
     */
    public static final String FORMAT_1 = "yyyy-MM-dd";

    /**
     * HH:mm:ss
     */
    public static final String FORMAT_2 = "HH:mm:ss";

    /**
     * yyyy-MM
     */
    public static final String FORMAT_3 = "yyyy-MM";

    /**
     * yyyyMM
     */
    public static final String FORMAT_4 = "yyyyMM";
    
    /**
     * yyyyMMddHHmmss
     */
    public static final String FORMAT_5 = "yyyyMMddHHmmss";

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

    public static String toDateNoHeng(Date... date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
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
    public static String toYearMonth(Date... date) {
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMM");
        if (date.length > 0) {
            return simple.format(date[0]);
        }
        return simple.format(new Date());
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
        if (!StringTools.checkEmpty(date))
            return new Date();
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
            if (simple == null)
                simple = new SimpleDateFormat(FORMAT_1);
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
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
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

    /*
     * 计算2个时间相隔的分钟数
     */
    public static int getTwoDateTimeMinutes(Date sour, Date tag) {
        long diff = tag.getTime() - sour.getTime();
        int mins = (int) (diff / (1000 * 60));
        return mins;
    }

    /**
     * 获取当前日期   
     * @param dateFormat
     * @return
     * @author JIANGZHE-01
     * @date 2015-1-14
     */
    public static String getCurrentTime(String dateFormat) {
        Date date = new Date();
        if (!StringTools.checkEmpty(dateFormat)) {
            dateFormat = FORMAT_0;
        }
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static String Timestamp2String(Timestamp timestamp) {
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp.getTime()));
    }

    /**
     * 获取目标时间与源时间相隔的天数,如20050901与20050930相隔29天
     * 
     * @param start
     *            格式要求yyyy-MM-dd
     * @param end
     *            格式要求yyyy-MM-dd
     * @return
     */
    public static int getIntervalDays(Date start, Date end) {
        long startMills = start.getTime();
        long endMills = end.getTime();
        int offset = 0;

        offset = (int) ((endMills - startMills) / DAY_MILLSECONDS);

        return offset;
    }

    /**
     * @param date
     * @return
     */
    public static int getDay_Of_Month(Date date) {
        GregorianCalendar gC = new GregorianCalendar();
        gC.setTime(date);
        return gC.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * get what hour is now
     * 
     * @return
     */
    public static int getCurrHour() {
        GregorianCalendar gC = new GregorianCalendar();
        return gC.get(GregorianCalendar.HOUR_OF_DAY);
    }

    /**
     * @param start
     *            yyyy-MM-dd
     * @param end
     *            yyyy-MM-dd
     * @return
     */
    public static int getIntervalMonths(Date start, Date end) {
        GregorianCalendar startGC = new GregorianCalendar();
        GregorianCalendar endGC = new GregorianCalendar();
        startGC.setTime(start);
        endGC.setTime(end);

        int endY = endGC.get(GregorianCalendar.YEAR);
        int endM = endGC.get(GregorianCalendar.MONTH);
        int endD = endGC.get(GregorianCalendar.DAY_OF_MONTH);

        int startY = startGC.get(GregorianCalendar.YEAR);
        int startM = startGC.get(GregorianCalendar.MONTH);
        int startD = startGC.get(GregorianCalendar.DAY_OF_MONTH);

        int offset = -1;

        if (endD == startD) {
            offset = endM - startM + (endY - startY) * 12;
        }

        return offset;
    }

    /**
     * @return Date
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 
     * @return
     */
    public static Date getYesterday() {
        return addDays(-1);
    }

    /**
     * 
     * @param days
     *            int
     * @return Date
     */
    public static Date addDays(int days) {
        return addDays(new Date(), days);
    }

    /**
     * srcDate+days
     * 
     * @param srcDate
     *            Date
     * @param days
     *            int
     * @return Date
     */
    public static Date addDays(Date srcDate, int days) {
        GregorianCalendar gCanlendar = new GregorianCalendar();
        gCanlendar.setTime(srcDate);
        gCanlendar.add(Calendar.DAY_OF_MONTH, days);
        return gCanlendar.getTime();
    }

    /**
     * 
     * @param srcDate
     * @param months
     * @return
     */
    public static Date addMonths(Date srcDate, int months) {
        GregorianCalendar gCanlendar = new GregorianCalendar();
        gCanlendar.setTime(srcDate);
        gCanlendar.add(Calendar.MONTH, months);
        return gCanlendar.getTime();
    }

    /**
     * srcDate+year
     * 
     * @param srcDate
     *            Date
     * @param year
     *            int
     * @return Date
     */
    public static Date addYears(Date srcDate, int year) {
        GregorianCalendar gCanlendar = new GregorianCalendar();
        gCanlendar.setTime(srcDate);
        gCanlendar.add(Calendar.YEAR, year);
        return gCanlendar.getTime();
    }

    /**
     * dest
     * 
     * @param dest
     *            Date
     * @return int 0
     */
    public static int compareTo(Date dest) {
        return compareTo(new Date(), dest);
    }

    /**
     * @param src
     *            Date
     * @param dest
     *            Date
     * @return
     */
    public static int compareTo(Date src, Date dest) {
        Date src1 = parse(format(src, "yyyy-MM-dd"), "yyyy-MM-dd");
        Date src2 = parse(format(dest, "yyyy-MM-dd"), "yyyy-MM-dd");
        int i = src1.compareTo(src2);
        return i;
    }

    /**
     * @param d
     *            Date
     * @param pattern
     *            String
     * @return String
     */
    public static String format(Date d, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }

    public static String format(Date d) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(d);
    }

    /**
     * @param date
     *            String
     * @param srcPattern
     *            String
     * @param destPattern
     *            String
     * @return String
     */
    public static String format(String date, String srcPattern, String destPattern) {
        Date d = parse(date, srcPattern);
        if (d == null) {
            return null;
        }

        return format(d, destPattern);
    }

    /**
     * @param date
     *            String
     * @param srcPattern
     *            String
     * @return Date
     */
    public static Date parse(String date, String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date modifyDate(Date date, int hour, int minute, int second) {
        GregorianCalendar gC = new GregorianCalendar();
        gC.set(Calendar.HOUR_OF_DAY, hour);
        gC.set(Calendar.MINUTE, minute);
        gC.set(Calendar.SECOND, second);
        return gC.getTime();
    }

    public static Date parse(String date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if (date.indexOf(":") == -1)
            pattern = "yyyy-MM-dd";
        return parse(date, pattern);
    }
    
    /*将YYYYMMDDHHMMSS的时间格式转换为YYYY年MM月DD日HH时MM分SS秒的时间格式*/
    public static String parseStringDate(String date,String patten) {
    	int n=(date.length()-4)/2+1;
    	StringBuffer time=new StringBuffer();
    	if (n>0) {
    		for (int i = 0; i <n; i++) {
    			if (i==0) {
    				time.append(date.substring(0, 4));
    				if (n>1) {
    					time.append("-");
					}
    				date=date.substring(4, date.length());
    			}
    			if (i==2&&date.length()>=2) {
    				time.append(date.substring(0, 2));
    				time.append(" ");
    				date=date.substring(2, date.length());
				}
    			if (i==1&&date.length()>=2) {
    				time.append(date.substring(0, 2));
    				if (n>2) {
    					time.append("-");
					}
    				date=date.substring(2, date.length());
    			}
    			if (i==n-1&&date.length()>=2) {
    				time.append(date.substring(0, 2));
    				date=date.substring(2, date.length());
    			}
    			if(!(i==0||i==2||i==1||i==n-1)&&date.length()>=2){
    				time.append(date.substring(0, 2));
    				time.append(":");
    				date=date.substring(2, date.length());
    			}
    		}
		}
    	Date t=DateUtils.parse(time.toString());
    	SimpleDateFormat sdf=new SimpleDateFormat(patten);
    	String str=sdf.format(t);
    	return str;
    	/*StringBuffer time=new StringBuffer();
    	time.append(date.substring(0,4)).append("年").append(date.substring(4, 6)).append("月").
    	append(date.substring(6, 8)).append("日  ").append(date.substring(8, 10)).append("时").
    	append(date.substring(10, 12)).append("分").append(date.substring(12, 14)).append("秒");
    	return time.toString();*/
    }
    
    
    /**
     * 当前的Timestamp
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取统计月份列表   
     * @param count
     * @return List
     * @author JIANGZHE-01
     * @date 2014-12-24
     */
    public static List<String> getCountMonthList(int count, String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        // 当前统计月份
        List<String> list = new ArrayList<String>();
        list.add(format.format(calendar.getTime()));
        // 后推统计月份
        for (int i = 1; i < count; i++) {
            calendar.add(Calendar.MONTH, -1);
            list.add(format.format(calendar.getTime()));
        }
        return list;
    }
}
