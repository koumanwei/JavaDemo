package com.koumanwei.inner;

/**
 * 内部类
 * 2017-04-08 16:45
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.run();
    }
}

// 内部类：
// 将一个类定义在另一个类的里面，对里面那个类就称为内部类（内置类/壳套类）
// 访问特点：
// 内部类可以直接访问外部类的成员，包括私有成员
// 而外部类要想访问内部类中的成员就必须建立内部类的对象

// 生成的class文件是有所属的Outer$Inner.class
// 一般用于类的设计
// 分析事物时，发现该事物中还有事物，而且发现这个事物还在访问被描述的事物

class Outer {
    private int num = 3;

    class Inner {
        void show() {
            System.out.println(num);
        }
    }

    public void run() {
        Inner inner = new Inner();
        inner.show();
    }
}