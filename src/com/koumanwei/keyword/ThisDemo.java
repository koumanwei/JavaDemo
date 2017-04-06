package com.koumanwei.keyword;

/**
 * 2017-04-06 上午10:10
 *
 * @author koumanwei
 * @version 1
 */
public class ThisDemo {
    public static void main(String[] args) {
        Person person = new Person("ZhangSan", 45);
        Person person1 = new Person("LiSi", 34);
        boolean b = person.equaleAge(person1);
        System.out.println(b);
    }

    static class Person {
        private String name;
        private int age;

        // 这个构造函数进栈以后，里面有一个局部变量name,如果不加上this,那么相当于把局部变量
        // name赋值给自己，应该把这个局部变量里面的name赋值给对象里面的name

        // this：代表的是一个对象
        // 代表哪个对象呢？
        // 哪个对象调用了this所在的函数，this就代表哪个对象
        // this就是当前对象的引用
        // 类中的成员都要被对象所调用

        // this什么时候用呢？
        // 当定义功能时，功能内部使用到了调用改功能的对象，这时就用this表示

        // this的表现形式之一：当局部变量和成员变量重名的时候，可以使用this来进行区分
        // this的表现形式之二：在构造函数中的使用，但是必须放在第一条语句

        public Person() {
            System.out.println("调用了空构造函数");
        }

        public Person(String name) {
            // 注意：调用本类中构造函数的this语句，必须放在构造函数的第一行
            this();
            System.out.println("调用了一个构造参数的构造函数");
            this.name = name;
        }

        public Person(String name, int age) {
            this(name);
            this.age = age;
        }

        // 需求：在Person类中定义一个比较的方法，判断是否是同龄人
        // 明确返回值：boolean
        // 明确未知内容
        public boolean equaleAge(Person person) {
            // 当前对象和传入的对象进行年龄的比较
            // 当前对象this,传入的对象person
            return this.age == person.age;
        }
    }
}
