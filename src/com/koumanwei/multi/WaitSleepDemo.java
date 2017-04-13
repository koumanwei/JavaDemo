package com.koumanwei.multi;

/**
 * wait和sleep的区别
 * 2017-04-13 上午11:44
 *
 * @author koumanwei
 * @version 1.0
 */
public class WaitSleepDemo {
    public static void main(String[] args) {

    }
    // 1、wait可以指定时间也可以不指定时间，sleep必须指定时间
    // 2、在同步中，对cpu的执行权和锁的处理不同
    // wait：释放执行权，释放锁
    // sleep：释放执行权，不释放锁
}
