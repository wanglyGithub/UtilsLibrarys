package com.wangly.utilslibary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangly on 2016/12/27.
 */

public class DataUtils {

    /**
     * 获取系统当前时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getSystemCurrentTime(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date).toString().trim(); // 当期日期
    }


    /**
     * 将普通时间转换为 Unix 时间戳
     *
     * @param dateFormat 时间格式：yyyy-MM-dd hh:mm:ss
     */
    public static long commonChangeUnixDate(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime() / 1000;
        System.out.println(time);
        return time;
    }

    /**
     * Unix时间戳转换成时间格式
     *
     * @param dataFormat 日期格式
     * @param timeStamp  时间戳
     * @return dataFormat
     */
    public static String formatData(String dataFormat, long timeStamp) {
        String result = "";
        timeStamp = timeStamp * 1000;
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }

    /**
     * 获取格式化之后的时间
     *
     * @param time
     * @param format "xxxx年x月xx日 xx:xx"
     * @return 转换之后的日期格式
     */
    public static String getFormatAfterDate(String time, String format) {
        if ("".equals(time)) {
            throw new NullPointerException("time not null exception!");
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf1.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }//提取格式中的日期
        String newStr = sdf2.format(date); //改变格式
        return newStr;
    }


    /**
     * 格式化时间（输出类似于 刚刚, 4分钟前, 一小时前, 昨天这样的时间）
     *
     * @param time    需要格式化的时间 如"2014-07-14 19:01:45"
     * @param pattern 输入参数time的时间格式 如:"yyyy-MM-dd HH:mm:ss"
     *                <p/>如果为空则默认使用"yyyy-MM-dd HH:mm:ss"格式
     * @return time为null，或者时间格式不匹配，输出空字符""
     */
    public static String formatDisplayTime(String time, String pattern) {
        String display = "";
        int tMin = 60 * 1000;
        int tHour = 60 * tMin;
        int tDay = 24 * tHour;

        if (time != null) {
            try {
                Date tDate = new SimpleDateFormat(pattern).parse(time);
                Date today = new Date();
                SimpleDateFormat thisYearDf = new SimpleDateFormat("yyyy");
                SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-M-d");
                Date thisYear = new Date(thisYearDf.parse(thisYearDf.format(today)).getTime());
                Date yesterday = new Date(todayDf.parse(todayDf.format(today)).getTime());
                Date beforeYes = new Date(yesterday.getTime() - tDay);
                if (tDate != null) {
                    SimpleDateFormat halfDf = new SimpleDateFormat("M月d日 HH:mm");
                    long dTime = today.getTime() - tDate.getTime();
                    if (tDate.before(thisYear)) {
                        display = new SimpleDateFormat("M月d日 HH:mm").format(tDate);
                    } else {

                        if (dTime < tMin) {  //刚刚
//							display = "刚刚";
                            display = new SimpleDateFormat("HH:mm").format(tDate);
                        } else if (dTime < tHour) {  //分钟前
//							display = (int) Math.ceil(dTime / tMin) + "分钟前";
                            display = new SimpleDateFormat("HH:mm").format(tDate);
                        } else if (dTime < tDay && tDate.after(yesterday)) { //小时前
//							display = (int) Math.ceil(dTime / tHour) + "小时前";
                            display = new SimpleDateFormat("HH:mm").format(tDate);
                        } else if (tDate.after(beforeYes) && tDate.before(yesterday)) { //昨天
                            display = "昨天" + new SimpleDateFormat("HH:mm").format(tDate);
                        } else {
                            display = halfDf.format(tDate);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return display;
    }
}
