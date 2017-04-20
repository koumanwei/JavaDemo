package com.koumanwei.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2017-04-20 20:58
 *
 * @author koumanwei
 * @version 1.0
 */
public class DateDemo {
    public static void main(String[] args) {
        // 将当前日期和时间封装成Date对象
        Date date1 = new Date(298787234);
        Date date = new Date();
        // 当前系统时间的毫秒值
        long time = date.getTime();
//        System.out.println(time);
//        System.out.println(date);
//        format();
//        format2();
        format3();
    }

    /**
     * 对日期对象进行格式化
     */
    private static void format() {
        // 日期对象
        Date date = new Date();
        // 获取日期格式对象，具备着默认的风格
        // 这个是获取日期时间的，只有年月日
        DateFormat date1 = DateFormat.getDateInstance();
        String s1 = date1.format(date);
        // 打印结果 2017-4-20
        System.out.println(s1);

        // 这个既包含年月日又包含时间
        DateFormat date2 = DateFormat.getDateTimeInstance();
        String s2 = date2.format(date);
        // 打印结果 2017-4-20 21:42:57
        System.out.println(s2);

        // 获取带风格的
        DateFormat date3 = DateFormat.getDateInstance(DateFormat.FULL);
        String s3 = date3.format(date);
        // 打印结果 2017年4月20日 星期四
        System.out.println(s3);

        // 获取带风格的
        DateFormat date4 = DateFormat.getDateInstance(DateFormat.LONG);
        String s4 = date4.format(date);
        // 打印结果 2017年4月20日
        System.out.println(s4);


        // 这个既包含年月日又包含时间
        DateFormat date5 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String s5 = date5.format(date);
        // 打印结果 2017年4月20日 下午09时50分43秒
        System.out.println(s5);
    }

    /**
     * 如果我们不像用上面的已经固化的形式，向要自己定义自己的风格
     * 那么就是用另外一个类
     */
    private static void format2() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        // 打印结果 2017-04-20 22:01:22
        System.out.println(s);
    }

    /**
     * 将日期格式的字符串转成日期对象
     */
    private static void format3() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        // 我们自定义的风格
        String s1 = "2017---08---09";
        // 那么默认的格式化对象就不能认识这个格式，所以还要创建一个对象的格式化对象
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy---MM---dd");
        try {
            Date d = simpleDateFormat.parse(s);
            Date d1 = simpleDateFormat1.parse(s1);
            System.out.println(d);
            System.out.println(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
