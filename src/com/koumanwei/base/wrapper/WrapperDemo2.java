package com.koumanwei.base.wrapper;

/**
 * 基本数据类型的自动装箱拆箱
 * 2017-04-13 下午5:41
 *
 * @author koumanwei
 * @version 1.0
 */
public class WrapperDemo2 {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(6);
        // false
        System.out.println(a == b);
        // true 因为Integer比较的是数值的大小
        System.out.println(a.equals(b));
        // 比较大小 0表示相等 1表示大于 -1表示小于
        int i = a.compareTo(b);
        System.out.println(i);

        // jkd1.5以后
        // 简化了定义方式
        // Integer x = new Integer(4);
        // 上面的定义可以直接写成
        // 自动装箱
        Integer x = 4;
        // 其实x会先变成基本数据类型
        // 自动拆箱
        // x = new Integer(x.intValue() + 6); i.inValue();
        x = x + 6;

        Integer c = new Integer(127);
        Integer d = new Integer(127);

        System.out.println(c == d); // false
        System.out.println(c.equals(d)); // true

        Integer e = 127;
        Integer f = 127;
        // jdk1.5以后，如果装箱的是一个字节，那么该数据会被共享
        // 不会开辟新的空间
        // 所以129两个字节，会变成false

        System.out.println(e == f); // true
        System.out.println(e.equals(f)); // true
    }
}
