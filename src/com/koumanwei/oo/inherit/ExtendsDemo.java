package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 下午4:40
 *
 * @author koumanwei
 * @version 1
 */
public class ExtendsDemo {
    /**
     * 继承的好处：
     */
    // 提高了代码的复用性
    // 让类与类之间产生了关系
    // 将对象中的共性内容不断地向上抽取，就形成了关系，就有了继承，有了子类和父类，提高了代码的复用
    // 1、java只能单继承，多继承的机制被java语言改良了
    // 单继承：一个类只能有一个父类
    // 多继承：一个类可以有多个父类

    // java不直接支持多继承，原因：会产生调用的不确定性
    // java支持多层（重）继承，这样就出现了继承体系
    // C extends B B extends A

    // 如何使用一个继承体系中的成员呢？
    // 1、查阅该体系中的顶层内容，因为通过该类可以了解该体系的基本功能
    // 2、创建最子类的对象，既可以调用共性的基本功能，也可以使用子类特有的功能
    // 简单说，看父类内容，建子类对象

    // 什么时候定义集成呢？
    // 必须是事物之间存在着所属关系，才定义继承
    // 所属关系：xxx是zzz中的一种， is a关系
    // 误区：不要仅仅为了提高复用，为了方便获取吉他类的内容而去继承
    public static void main(String[] args) {
        Student student = new Student("LiSi", 56);
        System.out.println(student.age);
    }
}

/**
 * 父类（超类/基类）
 */
class Person {
    protected String name;
    protected int age;
}

class Student extends Person {
    public Student(String name, int age) {
        super.name = name;
        super.age = age;
    }

    public void study() {
    }
}

class Worker extends Person {
    public Worker(String name, int age) {
        super.name = name;
        super.age = age;
    }

    public void work() {
    }
}
