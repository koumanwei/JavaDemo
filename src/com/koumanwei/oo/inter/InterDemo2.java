package com.koumanwei.oo.inter;

/**
 * 2017-04-07 下午4:41
 *
 * @author koumanwei
 * @version 1.0
 */
public class InterDemo2 {
    public static void main(String[] args) {
        System.out.println(B.NUM);
        System.out.println(C.NUM);
        System.out.println(new D().NUM);
    }
}

// 一个类在继承另一个类的同时可以实现多个接口
// C继承了A，所以C有了A中的show方法，同时实现了B，必须实现C中的show，但是继承下来的show正好覆盖了
// 所以C中可以不必去覆盖show
// 但是，A中的方法必须是public权限，因为继承下来的方法想要覆盖接口中的方法，根据子类覆盖父类方式时
// 权限必须大于等于父类的权限，因为接口中的方法都是public，所以。。

// 接口与接口之间是什么关系呢？

// 类和类之间是继承关系，而且是单继承
// 类与接口之间是实现关系
// 接口与接口之间是继承关系，而且可以多继承，因为类多继承带来的调用不确定性
class A {
    public void show() {
        System.out.println("A");
    }
}

interface B {
    public static final int NUM = 4;

    public abstract void show();
}

interface C extends B {
    public abstract void show();
}

class D extends A implements B {

}