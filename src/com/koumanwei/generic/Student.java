package com.koumanwei.generic;

import com.koumanwei.bean.Person;

/**
 * 2017-04-18 23:58
 *
 * @author koumanwei
 * @version 1.0
 */
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student:" + getName() + " " + getAge();
    }
}
