package com.koumanwei.oo;

/**
 * 2017-04-05 23:46
 *
 * @author koumanwei
 * @version 1
 */
public class EncapsulationDemo {
    // 封装：
    // 是指隐藏对象的属性和实现细节，进对外提供公共的访问方式

    // 好处：
    // 将变化隔离
    // 便于使用
    // 提高重用性
    // 提高安全性

    // 封装的原则：
    // 将不需要对外提供的内容都隐藏起来
    // 把属性都隐藏，提供公共方法对其访问

    // private：私有，是一个权限修饰符，用于修饰成员，不能修饰局部变量
    // 私有的内容只在本类中有效
    // 注意：私有仅仅是封装的一种体现而已

    // 在java中，最小的封装体，就是函数，类也是封装体
    // 函数调用之后有一个结果，但是怎么实现的我们并不知道

    public static void main(String[] args) {
        Person person = new Person();
        person.speak();
    }
}

class Person {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            // 此处应该抛出异常
            System.out.println("错误的数据");
        }
    }

    private int age;

    public void speak() {
        System.out.println("age=" + age);
    }
}