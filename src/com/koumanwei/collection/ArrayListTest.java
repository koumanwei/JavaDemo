package com.koumanwei.collection;

import com.koumanwei.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2017-04-17 下午4:13
 *
 * @author koumanwei
 * @version 1.0
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Person("zanshan", 18));
        list.add(new Person("lisi", 19));
        list.add(new Person("wangwu", 20));
        list.add(new Person("zhaoliu", 21));
        list.add(new Person("tianqi", 22));
        list.add(new Person("huba", 23));
        list.add(new Person("baifengjiu", 24));

        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Person person = (Person) iterator.next();
            // 记住：不要写两个next
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
