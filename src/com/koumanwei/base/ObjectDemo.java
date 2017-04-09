package com.koumanwei.base;

/**
 * Object类：所有类的根类
 * 2017-04-09 14:48
 *
 * @author koumanwei
 * @version 1.0
 */
public class ObjectDemo {
    public static void main(String[] args) {
        // Object是不断向上抽取的，具备这所有对象都具备的共性内容
        // 常用的共性内容
        // equals()方法
        Person p1 = new Person(30, "xiaoming");
        Person p2 = new Person(30, "xiaoming");
        Person p3 = p1;
        // 比较的是地址
        System.out.println(p1 == p2);
        // 比较的也是地址
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1);
        System.out.println(Integer.toHexString(p1.hashCode()));
        // 内部其实就是下面的这个方法
        System.out.println(p1.toString());
        System.out.println(p1.getClass().getName() + "@" + Integer.toHexString(p1.hashCode()));
    }
}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // 比较Person的年龄是否是同龄人
    public boolean compare(Person person) {
        return this.age == person.age;
    }

    /**
     * 一般都会覆盖此方法，根据对象的特有内容，建立判断对象是否相同的依据
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // 向下转型的时候要注意健壮性的判断
        if (!(obj instanceof Person)) {
            // 这里是覆写父类的方法，不能抛出受检测异常
            // 因为需要声明，但是子类不能比父类抛出更多的异常，所以不能用throws声明
            throw new ClassCastException("类型错误");
        } else {
            // 因为发生了向上转型，不能访问子类的特有内容
            Person person = (Person) obj;
            return this.age == person.age;
        }
    }

    @Override
    public int hashCode() {
        // 将人的年龄作为哈希值
        return this.age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}