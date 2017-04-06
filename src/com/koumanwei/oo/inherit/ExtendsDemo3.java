package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 21:59
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo3 {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

// 当子父类中成员函数一模一样的情况，会运行子类的函数
// 这种现象，称为覆盖操作，这是函数在子父类中的特性
// 函数的两个特性：
// 重载，同一个类中。overload
// 覆盖：子类中，也称为重写，覆写，override

// 覆盖的注意事项：
// 子类方法覆盖父类方法时，子类权限必须大于等于父类的权限
// 静态只能覆盖静态，或者被静态覆盖


class Father {
    void show() {
        System.out.println("Father");
    }
}

class Son extends Father {
    void show() {
        System.out.println("Son");
    }
}
