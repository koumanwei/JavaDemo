package com.koumanwei.other;

import java.util.Calendar;

/**
 * 2017-04-20 22:33
 *
 * @author koumanwei
 * @version 1.0
 */
public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println(getDays(2017));
        Calendar calendar = Calendar.getInstance();
        // 以年为单位，向前偏移两年，如果是负数，就是向后偏移
        calendar.add(Calendar.YEAR, 2);
        // 设置某个日期
        calendar.set(2011, 2, 23);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // 老外的第一天是星期天
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "年" + month + "月" + day + "日" + getWeek(week));
    }

    public static String getWeek(int i) {
        String[] week = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return week[i - 1];
    }

    /**
     * 获取某年的2月份的天数
     *
     * @param year
     * @return
     */
    private static int getDays(int year) {
        Calendar calendar = Calendar.getInstance();
        // 某一年的3月1号
        calendar.set(year, 2, 1);
        // 往前一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        // 这样就可以得到二月份的天数
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        return i;
    }
}
