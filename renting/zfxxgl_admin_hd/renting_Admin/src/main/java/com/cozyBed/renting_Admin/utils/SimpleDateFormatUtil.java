package com.cozyBed.renting_Admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: renting
 * @Package: cn.itcast.ssm.utils
 * @ClassName: SimpleDateFormatUtil
 * @Description: 获取时间的工具类
 * @Author: zy
 * @CreateDate: 2019/12/5 9:31
 * @Version: 1.0
 */
public class SimpleDateFormatUtil {
    /**
     * 获取当前日期时间
     * @return
     */
    public static String getDateTime(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(new Date());
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getDate(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(new Date());
    }

    /**
     * 将长日期字符串转成短日期字符串
     * @param datatime
     * @return
     */
    public static String dataTimeToData(String datatime){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sd.parse(datatime);
            return sd.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前日期之前或者之后的日期
     * @param day 可输入正数，表示当前日期之后；  负数表示当前日期之前
     * @return
     */
    public static String getOtherDate(Integer day){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date curr = new Date();
        long ms = curr.getTime() + day*24*3600*1000L;
        return sd.format(new Date(ms));
    }

    public static void main(String[] args) {
        System.out.println(getOtherDate(-6));
    }
}
