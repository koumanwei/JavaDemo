package com.koumanwei.collection;

import com.koumanwei.bean.Person;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 往HashSet集合中存储Person对象，如果姓名和年龄相同，那么视为同一个人
 * 2017-04-18 0:03
 *
 * @author koumanwei
 * @version 1.0
 */
public class HashSetTest {
    public static void main(String[] args) {
        // HashSet集合数据结构是哈希表，所以储存元素的时候
        // 使用的元素的HashCode方法来确定位置，如果位置相同
        // 在通过元素的equals来确定是否相同
        HashSet hashSet = new HashSet();
        hashSet.add(new Person("lisi4", 23));
        hashSet.add(new Person("lisi7", 34));
        hashSet.add(new Person("lisi8", 21));
        hashSet.add(new Person("lisi9", 53));
        hashSet.add(new Person("lisi3", 28));
        hashSet.add(new Person("lisi3", 28));
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
