package com.koumanwei.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2017-04-20 22:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class DateDemo2 {
    public static void main(String[] args) {
        // 2013-3-17 到 2014-4-6中间有多少天
        // 两个日期相减
        // 先转换成日期对象
        String s1 = "2013-3-17";
        String s2 = "2014-4-6";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        try {
            Date parse1 = format.parse(s1);
            Date parse2 = format.parse(s2);
            long l = parse1.getTime() - parse2.getTime();
            long day = l / (1000 * 60 * 60 * 24);
            System.out.println(Math.abs(day));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
