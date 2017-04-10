package com.koumanwei.multi;

/**
 * 2017-04-10 下午3:12
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}

// 如何创建线程呢？
// 方式一：继承Thread类并重写run方法
// 那为什么要继承Thread类，又要重写run方法呢？

// 因为线程要执行什么任务，线程自己肯定有定义
// 这个定义就是run方法，这个方法中定义就是线程要运行的内容
// 可是该run方法的内容并不是我们所需要的
// 怎么能让线程运行我们自定义的内容呢？
// 只有覆盖Thread中的run方法，覆盖之前需要先继承

// 注意：每个线程在栈内存中都对应着有自己的独立区域

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println("线程名称:" + Thread.currentThread().getName()
                    + "，线程Id:" + Thread.currentThread().getId());
        }
    }
}

