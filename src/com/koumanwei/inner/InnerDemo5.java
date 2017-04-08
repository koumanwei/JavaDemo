package com.koumanwei.inner;

/**
 * 匿名内部类
 * 2017-04-08 20:00
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo5 {
    public static void main(String[] args) {
        OuterD outerD = new OuterD();
        outerD.method();
    }
}

// 匿名内部类。就是内部类的简写形式
// 必须有前提，内部类必须继承或者实现一个外部类或者接口
// 匿名内部类其实就是一个子类对象
// 格式：new 父类(){}
abstract class Demo {
    abstract void show();
}

class OuterD {
    void method() {
        new Demo() {
            @Override
            void show() {
                System.out.println("nihao");
            }
        }.show();
    }

}