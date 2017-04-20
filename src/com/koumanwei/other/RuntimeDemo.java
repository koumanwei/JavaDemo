package com.koumanwei.other;

/**
 * 2017-04-20 下午5:50
 *
 * @author koumanwei
 * @version 1.0
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        // 没有构造方法摘要，说明该类不可以创建对象，
        // 又发现还有非静态的方法，说明该类应该提供了静态的返回该类对象的方法
        // 说明Runtime类使用了单例设计模式
        Runtime runtime = Runtime.getRuntime();
    }
}
