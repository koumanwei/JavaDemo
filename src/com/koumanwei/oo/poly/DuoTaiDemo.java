package com.koumanwei.oo.poly;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 2017-04-08 1:54
 *
 * @author koumanwei
 * @version 1.0
 */
public class DuoTaiDemo {
    // 面向对象编程有三大特性：封装、继承、多态。
    // 多态：即使一个对象对应着不同的类型
    // 多态在代码中的体现：
    // 父类或者接口的引用指向其子类的对象

    // 多态的好处，提高了代码的扩展性，前期定义的代码，可以使用后期的内容
    // 多态的弊端：前期定义的内容不能调用后期子类的特有内容

    // 多态的前提：
    // 必须有实现或者继承
    // 要有覆盖
    public static void main(String[] args) {
        // 自动类型提升，猫对象提升了动物类型
        // 但是特有功能无法访问
        // 作用就是可以限制特有功能的访问，提高扩展性

        // 向上转型：父类对象的引用指向子类对象
        Animal animal = new Cat();
        // 向下转型：指向子类对象的父类引用指向子类对象
        // 向下转型是为了使用子类中的特有方法

        // 注意：对于转型，自始自终都是子类对象在做着类型的变化
        Cat cat = (Cat) animal;
        method(cat);
    }

    public static void method(Animal animal) {
        // instanceof 用于判断对象的具体类型
        // 通常用于向下转型时的健壮性判断
        animal.eat();
        if (animal instanceof Cat) {
            ((Cat) animal).catchMouse();
        } else if (animal instanceof Dog) {
            ((Dog) animal).lookHome();
        }
    }
}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }

    public void lookHome() {
        System.out.println("看家");
    }
}