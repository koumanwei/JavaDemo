package com.koumanwei.generic;

/**
 * 2017-04-18 20:43
 *
 * @author koumanwei
 * @version 1.0
 */
public class Tool<T> {
    // 在jdk1.5之后，使用泛型来接收类中要操作的引用数据类型
    // 这就是泛型类，什么时候使用？当类中的操作的引用数据类型不确定的时候，就使用泛型来表示
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * 此方法是独立的，有自己的泛型
     *
     * @param str
     * @param <W>
     */
    public <W> void show(W str) {
        System.out.println("show:" + str);
    }

    /**
     * 此方法不是独立的，跟着对象走
     *
     * @param str
     */
    public void print(T str) {
        System.out.println("print:" + str);
    }

    /**
     * 当方法静态时，不能访问类中定义的泛型
     * 如果静态方法是用泛型，只能将泛型定义在方法上，泛型放在返回值的前面，修饰符的后面
     */
    public static <Q> void methoe(Q q) {
        System.out.println(q);
    }
}
