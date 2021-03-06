package com.koumanwei.design;

/**
 * 2017-04-06 上午11:39
 *
 * @author koumanwei
 * @version 1
 */
public class SingletonDemo {
    // 单例设计模式
    // 解决：保证一个类在内存中只能有一个对象
    // 思路：
    // 1、怎么保证这个对象是唯一的呢？
    // 其他程序随时用new创建该对象，无法控制个数，所以，不让其他程序创建该类对象
    // 所以构造函数私有化

    // 2、该类在本类中自己创建一个对象
    // 3、该类将创建的对象对外提供，让其他程序获取并使用
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton1 = singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton == singleton1);
    }
}

// 其实这样也是可以实现单例，但是这样不可控制
class Singleton1 {
    public static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }
}

/**
 * 饿汉式（开发用这种）（线程安全）
 */
class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    // 提供方法是为了可控
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉式（单例的延迟加载方式）（线程不安全）
 */
class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    // 提供方法是为了可控
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 懒汉式（单例的延迟加载方式）（线程安全）
 */
// 在被多线程并发访问时，会出现多线程安全问题
// 为了解决，加入了同步，虽然安全问题解决了，但是性能降低了
class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    // 当函数里面的代码都需要同步时，可以直接使用同步函数
    // 但是同步函数在这里效率较低，所以用同步函数
    // 这里降低了判断锁的次数
    // 可以通过双重判断的形式来完成这个过程
//    public synchronized static Singleton3 getInstance() {
    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}