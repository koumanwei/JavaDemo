package com.koumanwei.bean;

/**
 * 2017-04-18 下午4:40
 *
 * @author koumanwei
 * @version 1.0
 */
public class Student extends Person {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
