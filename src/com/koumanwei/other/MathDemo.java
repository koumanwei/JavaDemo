package com.koumanwei.other;

import java.util.Random;

/**
 * 2017-04-20 下午6:00
 *
 * @author koumanwei
 * @version 1.0
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        // 返回大于参数的最小整数
        double ceil1 = Math.ceil(14.56);
        // 返回小于参数的最小整数
        double ceil2 = Math.floor(14.56);
        // 返回四舍五入的最小整数
        double ceil3 = Math.round(14.56);
        // 返回0-1随机数
        double random = Math.random();
        Random ran = new Random();
        // 返回下一个随机数
        int i = ran.nextInt();
        System.out.println(random);
        System.out.println(ceil3);
    }
}
