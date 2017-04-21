package com.koumanwei.io;

import java.io.*;
import java.util.ArrayList;

/**
 * 对象的序列化
 * 2017-04-21 下午3:30
 *
 * @author koumanwei
 * @version 1.0
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("/Users/koumanwei/Desktop/writeObj.object");
        writeObj1(file);
        readObj1(file);
    }

    private static void writeObj(File desFilePath) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(desFilePath));
        // 被序列化的对象必须实现Serializable接口
        oos.writeObject(new Person("张三", 23));
        oos.close();
    }

    private static void readObj(File srcFilePath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcFilePath));
        // 对象的反序列化
        Person person = (Person) ois.readObject();
        System.out.println(person.getName() + " " + person.getAge());
    }

    private static void writeObj1(File desFilePath) throws IOException {
        ArrayList<Person> al = new ArrayList<>();
        al.add(new Person("张三", 23));
        al.add(new Person("谢霆锋", 38));
        al.add(new Person("朱茵", 45));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(desFilePath));
        // 被序列化的对象必须实现Serializable接口
        oos.writeObject(al);
        oos.close();
    }

    private static void readObj1(File srcFilePath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcFilePath));
        // 对象的反序列化

        // 张三 23
        // 谢霆锋 38
        // 朱茵 45

        ArrayList<Person> al = (ArrayList<Person>) ois.readObject();
        for (Person person : al) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
