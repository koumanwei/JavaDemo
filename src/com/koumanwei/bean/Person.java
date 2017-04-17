package com.koumanwei.bean;

/**
 * 2017-04-17 下午4:11
 *
 * @author koumanwei
 * @version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            throw new ClassCastException("类型不正确");
        }
        Person person = (Person) obj;
        // 比较内容是否相同
        boolean b = this.name.equals(person.name) && this.age == person.age;
        return b;
    }

    @Override
    public int hashCode() {
        // 返回哈希值，其实如果相同也无所谓，因为还要判断内容
        return name.hashCode() + age * 27;
    }

    public Person(String name, int age) {
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
