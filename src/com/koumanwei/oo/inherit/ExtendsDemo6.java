package com.koumanwei.oo.inherit;

/**
 * 2017-04-07 下午12:56
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo6 {
    public static void main(String[] args) {
        new ZiLei();
    }
}

class FuLei {

    public FuLei() {
        this.show();
    }

    void show() {
        System.out.println("FuLei show");
    }
}

class ZiLei extends FuLei {
    int num = 8;

    {
        System.out.println("ZiLei construct code num=" + num);
    }

    public ZiLei() {
//        super();
        // 显示初始化
        // 接着调用构造代码块
        System.out.println("construct function num=" + num);
    }

    void show() {
        System.out.println("ZiLei show num=" + num);
    }
    // 打印结果：
    // ZiLei show num=0
    // ZiLei construct code num=8
    // construct function num=8

    // 注意：没有打印父类的show，而打印子类show是因为子类覆盖了父类的方法

    // 一个对象再内存中的产生过程：
    // 1、将该对象所需的类文件加载进内存
    // 2、在内存进行空间的方法区空间分配
    // 3、通过new在堆内存中开辟空间
    // 4、对象中的属性进行默认初始化
    // 5、调用与之对象的构造函数进行初始化
    // 6、通过构造函数的super调用父类中的构造函数初始化
    // 7、对象中的属性进行显示初始化
    // 8、构造代码块初始化
    // 9、该构造函数内部自定义内容进行初始化

    // 其中5、6、7、8是隐式的
}