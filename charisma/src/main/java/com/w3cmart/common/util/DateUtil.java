package com.w3cmart.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 13708 on 2016/9/6.
 */
public class DateUtil {
    /**
     * 获取指定日期0点的毫秒值
     * @param date 日期字符串
     * @param pattern 格式，如果不传默认格式为：2016-09-06
     * @return
     * @throws ParseException
     */
    public static Long getDayZeroByPatter(String date, String pattern) throws ParseException {
        if(StringUtil.isEmpty(date)){
            return 0l;
        }
        if(StringUtil.isEmpty(pattern)){
            pattern = "yyyy-MM-dd";
        }
        Date parse = new SimpleDateFormat(pattern).parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        return getDayZeroWithCalendar(c);
    }

    public static Long getToDayZeroMillisecond(){
        Calendar calendar = Calendar.getInstance();
        return DateUtil.getDayZeroWithCalendar(calendar);
    }

    public static Long getTomorrowZeroMillisecond(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return DateUtil.getDayZeroWithCalendar(calendar);
    }

    public static Long getYesterdayZeroMillisecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return DateUtil.getDayZeroWithCalendar(calendar);
    }

    public static long getDayZeroWithCalendar(Calendar c){
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static Date getTomorrowDate(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }
}
