package com.koumanwei.oo;

/**
 * 2017-04-07 下午1:00
 *
 * @author koumanwei
 * @version 1.0
 */
public class ConsCondeDemo {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new A("xiaoming", 8);
        // 局部代码块 跟一般的语句一样，按顺序执行
        {
            int x = 9;
        }
    }
}

class A {
    private String name;
    private int age;

    // 构造代码块 定义在类的内部
    // 它可以给所有对象进行初始化
    // 而构造函数是对对应的对象初始化
    {
        System.out.println("你好，世界！");
    }

    public A() {
        System.out.println("A is run");
    }

    public A(String name, int age) {
        System.out.println(this.name + " " + this.age);
    }
}