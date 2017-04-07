package com.koumanwei.oo.abs;

/**
 * 2017-04-07 下午2:01
 *
 * @author koumanwei
 * @version 1.0
 */
public class AbsClassDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
// 当描述事物时，没有足够的信心对该事物进行描述时，那么该描述对应的类就是一个抽象类
// 例如描述狗
// 行为：吼叫
// 狼
// 行为：吼叫
// 狼和狗具备共性功能，可以抽取，
// 他们都是犬科中的一种，而吼叫是犬科中的基本功能

// 抽行类的特点：
// 1、没有方法体的方法是抽象方法，一定定义在抽象类中
// 2、抽象类和抽象方法必须用abstract修饰
// 3、抽象类不能被实例化，为啥？
// 因为调用抽象方法没有意思
// 4、抽象类必须由其子类覆盖掉所有的方法后，其子类才可以进行实例化，否则，该子类还是一个抽象类

// 抽象类一定是父类吗？
// 是

// 抽象类是否有构造函数？
// 有，因为是给子类提供初始化动作的

// 抽象类中是否可以定义不抽象的方法？
// 可以的，为了不让其创建对象

// 抽象关键字不能与那些关键字共存？
// final，final修饰类表示不能继承，所以是矛盾的
// private 因为不能被覆盖，所以矛盾
// static，因为用类名可以调用static方法，调用抽象方法没有意义

// 一般类和抽象类有什么异同呢？
// 1、相同之处，一般类和抽象类都是描述事物的，都可以定义属性，行为，构造函数
// 2、不同之处,一般类中不可以定义抽象函数,抽象类不能被实例化
// 3、一般类可以被继承，也可以不被继承
// 抽象类必须被继承

abstract class Canine {
    public Canine() {
        System.out.println("nihao");
    }

    abstract void bellow();
}

class Dog extends Canine {

    @Override
    void bellow() {
        System.out.println("wang wang");
    }
}

class Wolf extends Canine {

    @Override
    void bellow() {
        System.out.println("ao ao");
    }
}
