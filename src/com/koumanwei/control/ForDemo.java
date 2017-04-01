package com.koumanwei.control;

/**
 * 2017-04-01 下午2:06
 *
 * @author koumanwei
 * @version 1
 */
public class ForDemo {
    public static void main(String[] args) {
        for (int x = 0, y = 3; y < 9; x++, y++) {
            // for的厨师条件和循环后的表达式可以是多个
            // 中间是条件判断，只能是真和假，所以只能有一个
        }
        getDays();
    }

    /**
     * 3000米的绳子，每天减少一半，多少天以后生子的长度小于5米
     *
     * @return
     */
    public static void getDays() {
        // 1、绳子的长度在变化，用变量length记录
        // 2、天数在变化，用变量days记录
        // 3、绳子的初始值是3000
        int days = 0;
        for (int length = 3000; length >= 5; length /= 2) {
            days++;
        }
        System.out.println(days);
    }
}
