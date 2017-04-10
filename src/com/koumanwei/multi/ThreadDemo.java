package com.koumanwei.multi;

/**
 * 2017-04-10 下午1:42
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new A();
        new A();
        new A();
        new A();
        // 启动垃圾回收器
        // 会自动调用每个对象的finalize方法
        System.gc();
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.println("主线程：" + "名称：" + name + ",id:" + id);
    }
}
// 进程：正在进行中的程序
// 线程就是进程中一个执行单元（执行情景/执行路径）
// 负责进程中程序执行的控制单元

// 一个进程中至少有一个线程
// 多线程解决的问题，可以让多部分代码同时执行
// 什么是同时执行呢？
// 其实就是cpu在瞬间做着快速切换完成的
// cpu的切换时随机的，按照时间片的方式完成
// 其实java运行就是多线程的
// 在执行main函数中内容的同时，垃圾回收器也在回收堆内存的垃圾
// 所以执行main方法的线程，和执行垃圾回收器的线程同时在执行

class A {
    @Override
    protected void finalize() throws Throwable {
        // Finalizer
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.println("垃圾回收器线程：" + "名称：" + name + ",id:" + id);
        System.out.println("被回收了");
    }
}