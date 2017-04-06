package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 23:04
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo4 {
    public static void main(String[] args) {

    }

    // 什么时候使用覆盖操作？
    // 当对一个类进行子类的扩展时，子类要保留父类的声明，
    // 但是要定义子类中该功能的特有内容时，就使用覆盖操作完成

}

class Phone {
    void show() {
        System.out.println("name");
    }
}

class NewPhone extends Phone {
    @Override
    void show() {
        super.show();
    }
}