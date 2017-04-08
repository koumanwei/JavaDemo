package com.koumanwei.inner;

/**
 * 2017-04-08 17:02
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo2 {
    public static void main(String[] args) {
        // 因为内部类相当于类中的成员，所以先有外部对象
        MyOuter.MyInner myInner = new MyOuter().new MyInner();
        myInner.show();
        // 如果内部类是静态的那么相当于一个外部类
        MyOuter.MyInner2 myInner2 = new MyOuter.MyInner2();
        // 如果内部类是静态的，成员也是静态的
        MyOuter.MyInner2.show();
    }
}

// 内部类跟类的成员是平行结构，所以可以被成员修饰符所修饰
// 注意：如果内部类中定义了静态成员，该内部类必须是静态的

class MyOuter {
    private int num = 3;

    class MyInner {
        void show() {
            System.out.println(num);
        }
    }

    static class MyInner2 {
        static void show() {
            System.out.println("");
        }
    }
}
