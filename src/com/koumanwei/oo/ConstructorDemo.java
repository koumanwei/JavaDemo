package com.koumanwei.oo;

/**
 * 2017-04-06 上午9:22
 *
 * @author koumanwei
 * @version 1
 */
public class ConstructorDemo {
    public static void main(String[] args) {
        // new 用于在堆内存中开辟空间的关键字，用于创建对象
        Person p = new Person();
    }

    static class Person {
        public Person() {
            System.out.println("person run");
            return;
        }
    }
    // 构造函数：
    // 1、与类同名
    // 2、没有具体的返回值
    // 3、给对象初始化

    // 特点：任何用class定义的类中，都有一个默认的空参数的构造函数
    // 如果该类中指定了具体的构造函数，那么默认的构造函数就没有了

    // 构造函数和一般函数的不同：
    // 1、书写格式的不同
    // 2、运行上的不同
    // 构造函数在对象一创建就被调用，而且只执行一次，一般函数是对象创建之后，对象所需时才被调用，可以调用多次
    // 构造函数什么时候用呢？
    // 当描述事物时，该事物一存在就具备一些属性和行为，那么就将这些内容定义在构造函数中

    // 构造函数中也是有return语句，用来控制初始化
}
