package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 23:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo5 {
    public static void main(String[] args) {
        HaiZi haiZi = new HaiZi();
        // 在子类构造对象时，发现，访问子类构造函数时，父类的构造函数也运行了。
        // 为什么呢？
        // 原因是：在子类的构造函数中第一行有一个默认的隐式语句，super();

        // 子类的实例化过程，子类所有的构造函数默认都会调用父类的空参数构造函数
    }
}

class FuQin {
    public FuQin() {
        System.out.println("FuQin");
    }
}

class HaiZi extends FuQin {
    public HaiZi() {
//        super();
        System.out.println("HaiZi");
    }
}