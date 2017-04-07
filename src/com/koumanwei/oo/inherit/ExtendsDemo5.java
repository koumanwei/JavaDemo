package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 23:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo5 {
    public static void main(String[] args) {
        HaiZi haiZi = new HaiZi(6);
        // 在子类构造对象时，发现，访问子类构造函数时，父类的构造函数也运行了。
        // 为什么呢？
        // 原因是：在子类的构造函数中第一行有一个默认的隐式语句，super();

        // 子类的实例化过程，子类所有的构造函数默认都会调用父类的空参数构造函数

        // 为什么子类的构造函数都要默认访问父类的构造函数呢？
        // 因为子类继承了父类，可以访问父类中的已有的一些属性
        // 在子类进行实例化的时候必须要为父类中的属性分配空间
        // 并要进行初始化，所以必须要访问一次父类的构造函数
        // 看看父类是如何对其属性进行初始化的
        // 所以子类在实例化对象时，必须要先看父类的初始化过程
        // 父类的构造函数，既可以给本类对象初始化，也可以个子类对象初始化
    }
}

class FuQin {
    public FuQin() {
        System.out.println("FuQin is run");
    }

    public FuQin(int x) {
        System.out.println("FuQin is run" + x);
    }
}

class HaiZi extends FuQin {
    public HaiZi() {
//        super();
        System.out.println("HaiZi");
    }

    public HaiZi(int x) {
//        super();
        this();
        System.out.println("HaiZi is run" + x);
    }

    // 子类的实例化过程，子类所有的构造函数默认都会调用父类的空参数构造函数
    // 可以得出结果。

    // 注意：如果父类中没有写空参的构造函数，那么子类的构造函数中就必须手动指定要访问的父类中的构造函数
    // 或者用this来指定访问本类中的构造函数
    // 要么访问默认的，要么访问指定的，必须访问一个
    // this和super调用构造函数只能定义在构造函数的第一行，不能同时出现
    // 为什么都定义在第一行啊？因为初始化的动作要先执行
}