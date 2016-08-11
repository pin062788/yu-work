package yuweixiang.first.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zjx
 * @date 2014-10-22
 */
public class DateUtil {

    /** 日期格式 年月日 */
    public static final String DATE_FORMAT_OUTPUT_DATE          = "yyyy/MM/dd";

    /** 时间格式，年月日，时分秒 */
    public static final String DATE_FORMAT_OUTPUT_TIME          = "yyyy/MM/dd HH:mm:ss";

    /** 时间格式，yyyy-MM-dd HH:mm:ss */
    public static final String NEW_DATE_FORMAT_OUTPUT_TIME      = "yyyy-MM-dd HH:mm:ss";

    /** 默认时间模式：yyyy/MM/dd HH:mm:ss:SSS */
    public static final String DEFAULT_FORMAT_OUTPUT_TIME       = "yyyy/MM/dd HH:mm:ss:SSS";

    /** 时间格式：yyyy/MM/dd HH:mm:ss:SSS */
    public static final String DATE_FORMAT_OUTPUT_ACCURATE_TIME = "yyyy/MM/dd HH:mm:ss:SSS";

    /** 时间格式:yyyyMMdd */
    public static final String DATE_FORMAT_LONG_8               = "yyyyMMdd";

    /** 时间格式:yyyy-MM-dd */
    public static final String DATE_FORMAT_LONG_10              = "yyyy-MM-dd";

    /** 时间格式:yyyyMMddHHmmss */
    public static final String DATE_FORMAT_LONG_14              = "yyyyMMddHHmmss";

    /**
     * 获取以默认格式标准化的当前时间
     *
     * @return 默认格式的时间
     */
    public static String getDefaultFormatCurrentDataTime() {
        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_FORMAT_OUTPUT_TIME);
        return sf.format(new Date());
    }

    /**
     * 方法说明：获得指定格式当前系统时间字符串
     *
     * @param pattern
     * @return 当前时间字符串
     */
    public static String getCurrentDateTime(String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(new Date());
    }

    /**
     * format date to string by input pattern
     *
     * @param date
     * @param pattern
     * @return String
     */
    public static String getDateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String returnDate = format.format(date);
        return returnDate;
    }

    /**
     * format current date to string by input pattern
     *
     * @param pattern
     * @return String
     */
    public static String getCurrentDateToString(String pattern) {
        Date date = new Date();
        return getDateToString(date, pattern);
    }

    /**
     * date --> string
     *
     * @param format
     * @param date
     * @return 转换后的时间字符串
     */
    public static String timeToString(String format, Date date) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * format date 'yyyy/MM/dd' to 'yyyyMMdd'
     * @param date 
     * @return string date
     */
    public final static String getFormatDateRemoveSprit(String date) {
        if (date == null) {
            return "";
        } else {
            return date.replace("/", "");
        }
    }

    /**
     * format date 'yyyyMMdd' to 'yyyy/MM/dd'
     * @param date 
     * @return string date
     */
    public final static String getFormatDateAddSprit(String date) {
        if (date == null) {
            return "";
        } else if (StringUtils.trim(date).length() != 8) {
            return date;
        } else {
            return StringUtils.trim(date).substring(0, 4) + "/"
                   + StringUtils.trim(date).substring(4, 6) + "/"
                   + StringUtils.trim(date).substring(6, 8);
        }
    }

    /**
     * format yyyy/MM/dd HH:mm:ss to yyyymmddhhmmss
     * @param date 
     * @return string date
     */
    public final static String getFormatDateRemoveSpritAndColon(String date) {
        if (date == null) {
            return "";
        } else {
            date = date.replace("/", "");
            date = date.replace(" ", "");
            date = date.replace(":", "");
            return date;
        }
    }

    /**
     * 截取日期
     * 
     * @param date
     * @return 截取结果
     */
    public final static String getFormatDateAddSpritAndColon(String date) {
        if (date == null) {
            return "";
        } else if (StringUtils.trim(date).length() != 14) {
            return date;
        } else {
            return StringUtils.trim(date).substring(0, 4) + "/"
                   + StringUtils.trim(date).substring(4, 6) + "/"
                   + StringUtils.trim(date).substring(6, 8) + " "
                   + StringUtils.trim(date).substring(8, 10) + ":"
                   + StringUtils.trim(date).substring(10, 12) + ":"
                   + StringUtils.trim(date).substring(12, 14);
        }
    }

    /**
     * compare dateString if date1 > date2,return true;else return false
     * @param date1 
     * @param date2 
     * @return boolean
     */
    public final static boolean compareDateString(String date1, String date2) {
        boolean flag = false;
        if (Double.valueOf(date1) - Double.valueOf(date2) > 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 将字符串日期转换成日期
     *
     * @param dateStr
     * @param formatStr 日期格式
     * @return  转换后日期
     */
    public final static Date StringToDate(String dateStr, String formatStr) {
        DateFormat dd = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = dd.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间的long值
     * 
     * @return long值格式时间
     */
    public static long getCurrentLongDateTime() {
        long currentDate = 0;
        try {
            currentDate = getLongDatetime(DATE_FORMAT_LONG_14,
                getCurrentDateToString(DATE_FORMAT_LONG_14));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    /**
     * 获取指定格式日期字符串对应的time
     * 
     * @param pattern 日期格式
     * @param dt 日期字符串
     * @return 转换结果
     */
    public static long getLongDatetime(String pattern, String dt) {

        long longDate = 0;
        try {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            longDate = sf.parse(dt).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longDate;
    }

    /**
     * 将long日期转换为字符串
     * 
     * @param date 日期的long值
     * @param pattern 日期格式
     * @return 指定格式的日期
     */
    public static String getLongDateToString(long date, String pattern) {
        if (date == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String returnDate = format.format(date);
        return returnDate;
    }

    /**
     *  日期的long值转换为日期格式的结果
     * 
     * @param date long值的日期
     * @param pattern 转换格式
     * @return 对应格式的日期
     */
    public static Date getLongDateToDate(long date, String pattern) {
        Date dateTime = null;
        if (date == 0) {
            return new Date();
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String returnDate = format.format(date);

        try {
            dateTime = format.parse(returnDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 获取创建时间后n分钟的时间
     *
     * @param createDate
     * @param minute 分钟数
     * @return 指定日期之后的日期
     */
    public static long getAfterTime(long createDate, int minute) {

        if (createDate == 0) {
            return 0;
        }
        String newDate = "";
        try {
            String oldDate = DateUtil.getLongDateToString(createDate, DATE_FORMAT_OUTPUT_TIME);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_OUTPUT_TIME);
            Date date = format.parse(oldDate);
            long Time = (date.getTime() / 1000) + 60 * minute;
            date.setTime(Time * 1000);
            newDate = DateUtil.getDateToString(date, DATE_FORMAT_LONG_14);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return DateUtil.getLongDatetime(DATE_FORMAT_LONG_14, newDate);
    }

    /**
     * 获取当前向前n秒的时间
     *
     * @param second
     * @return long值的日期
     */
    public static long getBeforeTime(int second) {
        Date dt = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(dt);
        ca.add(Calendar.SECOND, -second);//减30秒
        return DateUtil.getLongDatetime(DATE_FORMAT_OUTPUT_TIME,
            DateUtil.getDateToString(ca.getTime(), DATE_FORMAT_OUTPUT_TIME));
    }

    /**
     * 比较两个 Calendar 对象表示的时间值（从历元至现在的毫秒偏移量）。 如果参数表示的时间等于此 Calendar
     * 表示的时间，则返回 0 值； 如果此 Calendar 的时间在参数表示的时间之前，则返回小于 0 的值； 如果此
     * Calendar 的时间在参数表示的时间之后，则返回大于 0 的值
     *
     * @param firstDate
     * @param secondDate
     * @return 比较结果，0为相等，小于0表示firstDate在secondDate之前，否则大于0
     */
    public static int compare(Date firstDate, Date secondDate) {
        Calendar firstCalendar = null;
        /** 使用给定的 Date 设置此 Calendar 的时间。 **/
        if (firstDate != null) {
            firstCalendar = Calendar.getInstance();
            firstCalendar.setTime(firstDate);
        }

        Calendar secondCalendar = null;
        /** 使用给定的 Date 设置此 Calendar 的时间。 **/
        if (firstDate != null) {
            secondCalendar = Calendar.getInstance();
            secondCalendar.setTime(secondDate);
        }
        try {
            /**
             * 比较两个 Calendar 对象表示的时间值（从历元至现在的毫秒偏移量）。 如果参数表示的时间等于此 Calendar
             * 表示的时间，则返回 0 值； 如果此 Calendar 的时间在参数表示的时间之前，则返回小于 0 的值； 如果此
             * Calendar 的时间在参数表示的时间之后，则返回大于 0 的值
             * **/
            return firstCalendar.compareTo(secondCalendar);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 判断<firstDate>时间点是否在<secondDate>时间点之前
     * 如果此 firstDate 的时间在参数<secondDate>表示的时间之前，则返回小于 0 的值
     *
     * @param firstDate
     * @param secondDate
     * @return 比较结果
     */
    public static boolean isBefore(Date firstDate, Date secondDate) {
        return compare(firstDate, secondDate) < 0 ? true : false;
    }

    /**
     * 判断<firstDate>时间点是否在<secondDate>时间点之后
     * 如果此 firstDate 的时间在参数<secondDate>表示的时间之后，则返回大于 0 的值
     *
     * @param firstDate
     * @param secondDate
     * @return 比较结果
     */
    public static boolean isAfter(Date firstDate, Date secondDate) {
        return compare(firstDate, secondDate) > 0 ? true : false;
    }

    /**
     * 获取当前年月和上个月
     *
     * @param preFlag 
     * @return 获取结果
     */
    @SuppressWarnings("static-access")
    public final static String getYrAndMonth(boolean preFlag) {
        Calendar c = Calendar.getInstance();
        if (preFlag) {
            c.add(c.MONTH, -1);
        }
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        return year + "/" + month;
    }

    /**
     * 获取当前年份
     * @return 年份信息
     */
    public static Integer getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return Integer.valueOf(year);
    }

    /**
     * 获取当前月份
     * @return 月份
     */
    public static Integer getMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return Integer.valueOf(month);
    }

    /**
     * 获取两个时间内的时间差
     * @param startDate 
     * @param endDate 
     * @param pattern 
     * @return 差值
     */
    public static long getTimeDifferenceLog(String startDate, String endDate, String pattern) {
        SimpleDateFormat dfs = new SimpleDateFormat(pattern);
        long between = 0;
        try {
            Date begin = dfs.parse(startDate);
            Date end = dfs.parse(endDate);
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return between;
    }

    /**
     * 获取时间的long值
     * 
     * @param minute 分钟
     * @return 返回值
     */
    public static long getLongTime(long minute) {

        return 60 * minute * 1000;
    }

    /** 
     * 指定时间的多少天前的0点毫秒时间值 long
     *  
     * @param specifiedDay 指定日期
     * @param beforeSpecifiedDays 指定日期的多少天前
     * @return 指定时间的多少天前的0点毫秒值
     */
    public static long getSpecifiedDayBeforeZeroLongTime(Date specifiedDay, int beforeSpecifiedDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(specifiedDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day - beforeSpecifiedDays);
        return cal.getTime().getTime();
    }

    /** 
     * 获得指定日期的前一天的零点时间 long
     *  
     * @param specifiedDay 
     * @return 指定时间的上一天的0点毫秒值
     */
    public static long getSpecifiedDayZeroLongTime(Date specifiedDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(specifiedDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }
}
