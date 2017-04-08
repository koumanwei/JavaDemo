package com.koumanwei.inner;

/**
 * 局部内部类
 * 2017-04-08 19:24
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo4 {
    public static void main(String[] args) {
        OuterC outerC = new OuterC();
        outerC.method();
    }
}

// 内部类可以存放在局部位置上
// 内部类访问局部变量的时候，局部变量需要声明为final
// jdk1.8以后可以不用加上final，因为系统默认会给加上final
// 因为局部变量声明周期短，当方法执行完完以后，局部变量就消失了
// 内部类在局部位置上只能访问局部中被final修饰的局部变量
class OuterC {
    private int num = 3;

    void method() {
        // 被final修饰之后就变成常量了，声明周期变长，不是存在栈中
        final int x = 9;
        class InnerC {
            private void show() {
                System.out.println("show" + x);
            }
        }
        InnerC innerC = new InnerC();
        innerC.show();
    }
}