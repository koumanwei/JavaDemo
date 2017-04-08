package com.koumanwei.oo.poly;

/**
 * 2017-04-08 16:09
 *
 * @author koumanwei
 * @version 1.0
 */
public class DuoTaiDEmo2 {
    public static void main(String[] args) {
        // 多态中成员的特点：
        // 因为子类已经提升为父类
        // 所以打印结果是3不是4
        Fu fu = new Zi();
        fu.show();
        fu.show2();
        System.out.println(fu.num);
    }
}

// 1、成员变量：
// 编译时，参考引用型变量所属的类中是否有调用的成员变量，有，编译通过
// 运行时，参考应用型变量所属的类中是否有调用的成员变量
// 简单说，编译和运行都参考左边

// 2、成员函数（非静态）
// 编译时，参考引用型变量所属的类中是否有调用的成员函数，有，编译通过，否则，失败
// 运行时，参考的是对象所属的内中是否有调用的函数
// 简单说，编译看左边，运行看右边
// 成员变量不会发生覆盖，成员方法会
// 非静态方法依靠对象来调用，必须动态绑定到对象上

// 3、静态方法
// 不依靠对象来调用
// 也就不涉及多态，因为对象才有多态
class Fu {
    int num = 3;

    void show() {
        System.out.println("Fu show");
    }

    static void show2() {
        System.out.println("Fu show2");
    }
}

class Zi extends Fu {
    int hum = 4;

    void show() {
        System.out.println("Zi show");
    }

    static void show2() {
        System.out.println("Zi show2");
    }
}
