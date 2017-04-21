package com.koumanwei.io;

import java.io.Serializable;

/**
 * 2017-04-21 下午4:07
 *
 * @author koumanwei
 * @version 1.0
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 123456899L;
    private String name;
    private int age;
    // 这个money不会被写到硬盘上，因为有transient修饰了
    // 非静态数据不想被序列化可以使用这个关键字
    private transient long money;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
