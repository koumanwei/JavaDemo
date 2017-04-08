package com.koumanwei.inner;

/**
 * 2017-04-08 19:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo3 {
    public static void main(String[] args) {
        OuterA.InnerA innerA = new OuterA().new InnerA();
        innerA.show();
    }
}

// 为什么内部类可以直接访问外部累的成员？
// 因为内部类隐式持有外部内的引用
// 外部类名.this
class OuterA {
    private int num = 5;

    class InnerA {
        private int num = 4;

        void show() {
            int num = 3;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(OuterA.this.num);
        }
    }
}