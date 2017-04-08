package com.koumanwei.inner;

/**
 * 2017-04-08 23:52
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo7 {
    public static void main(String[] args) {
        new Zi();
    }
}

class Fu {
    public Fu() {
        show();
    }

    void show() {
        System.out.println("Fu show");
    }
}

class Zi extends Fu {
    int num = 9;

    {
        System.out.println("Zi 构造代码块");
    }

    public Zi() {
        super();
        // 显示初始化
        // 构造代码块初始化
        System.out.println("Zi 构造函数" + num);
    }

    void show() {
        System.out.println("Zi show" + num);
    }
}
// 打印的是 Zi show0
// 对象的初始化过程是这样的
// 首先加载父类的class文件，然后加载子类的class文件
// 接着调用子类的构造方法，因为子类中隐式调用了super方法
// 所以接着调用父类的构造方法，父类的构造方法中调用了show方法
// 但是因为子类已经覆盖了这个方法，所以调用子类的show方法
// 此时还没有显示初始化，所以num的值是0

// 注意：当创建一个子类的时候，首先子类的构造方法进栈，然后调用super()方法，
// 然后进行显示初始化，先后进行构造代码块