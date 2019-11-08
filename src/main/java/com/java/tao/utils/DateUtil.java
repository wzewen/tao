package com.java.tao.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_TIME_PATTERN2= "yyyyMMddHHmmss";
    public static final String DATE_TIME_PATTERN3= "yyyyMMddHHmmssSSS";
    public static final String DATE_PATTERN2 = "yyyyMMdd";

    /**
     * Date类型格式化成字符串
     */
    public static String dateFormat(Date date, String pattern){
        try {
            if (null==pattern || "".equals(pattern)) {
                //如果模板为空，输出默认时间格式 yyyy-MM-dd HH:mm:ss
                pattern = DateUtil.DATE_TIME_PATTERN;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            if (null == date) {
                return sdf.format(new Date());
            } else {
                return sdf.format(date);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String dateTimeToString(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_TIME_PATTERN);
        return dateTimeString;
    }

    /**
     * yyyy-MM-dd
     */
    public static String dateToString(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_PATTERN);
        return dateTimeString;
    }

    /**
     * HH:mm:ss
     */
    public static String timeToString(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.TIME_PATTERN);
        return dateTimeString;
    }

    /**
     * yyyyMMddHHmmss
     */
    public static Long dateTimeToLong(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_TIME_PATTERN2);
        return Long.parseLong(dateTimeString);
    }

    /**
     * yyyyMMddHHmmssSSS
     */
    public static Long dateTimeSecondToLong(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_TIME_PATTERN3);
        return Long.parseLong(dateTimeString);
    }

    /**
     * yyyyMMdd
     */
    public static Long dateToLong(Date dateTime){
        String dateTimeString = DateUtil.dateFormat(dateTime, DateUtil.DATE_PATTERN2);
        return Long.parseLong(dateTimeString);
    }

    /**
     * 字符串解析成时间对象
     */
    public static Date dateParse(String dateTimeString, String pattern){
        try{
            if(null==dateTimeString || "".equals(dateTimeString)){
                //如果时间为空，返回当前时间
                return new Date();
            }
            if(null==dateTimeString || "".equals(dateTimeString)){
                //如果模板为空，使用默认模板解析时间 yyyy-MM-dd HH:mm:ss
                pattern = DateUtil.DATE_TIME_PATTERN;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateTimeString);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static Date dateForDateTimeStr(String dateTime){
        return DateUtil.dateParse(dateTime, DateUtil.DATE_TIME_PATTERN);
    }

    /**
     * yyyy-MM-dd
     */
    public static Date dateForDateStr(String dateTime){
        return DateUtil.dateParse(dateTime, DateUtil.DATE_PATTERN);
    }

    /**
     * yyyyMMddHHmmss
     */
    public static Date dateForDateTimeLong(String dateTime){
        return DateUtil.dateParse(dateTime, DateUtil.DATE_TIME_PATTERN2);
    }

    /**
     * yyyyMMdd
     */
    public static Date dateForDateLong(String dateTime){
        return DateUtil.dateParse(dateTime, DateUtil.DATE_PATTERN2);
    }

    /**
     * 时间比较
     * date1 > date2 ，返回1；相等返回0；小于返回-1
     */
    public static int dateCompare(Date date1, Date date2) {
        Calendar myCal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        myCal.setTime(date1);
        compareCal.setTime(date2);
        return myCal.compareTo(compareCal);
    }

    /**
     * 时间增加
     * @param now
     * @param addNum
     * @return
     */
    public static Date addDate(Date now, int addNum){
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, addNum);
        return c.getTime();
    }

    /**
     * 时间差 天数
     * @param startDs
     * @param endDs
     * @return
     */
    public static int diffDate(String startDs,String endDs){

        Long from = dateForDateLong(startDs).getTime();
        Long to = dateForDateLong(endDs).getTime();
        int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * 返回日期的前一个月或后一个月的日期
     * @param date
     * @param month 正数 当期月份+ 负数，当期月份 -
     * @return
     */
    public static Date monthDate(Date date,int month){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,month);
        return dateForDateLong(dateFormat(cal.getTime(),"yyyyMMdd"));
    }
    /**
     * 返回日期所在月的天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args){
        Date date = addDate(new Date(), -247);
        System.out.println(dateTimeToString(date));

    }

}

