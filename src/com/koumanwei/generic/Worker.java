package com.koumanwei.generic;

import com.koumanwei.bean.Person;

/**
 * 2017-04-18 23:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class Worker extends Person {
    public Worker() {
    }

    public Worker(String name, int age) {

        super(name, age);
    }

    @Override
    public String toString() {
        return "Worker:" + getName() + " " + getAge();
    }
}
