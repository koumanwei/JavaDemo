package com.koumanwei.collection;

import com.koumanwei.bean.Person;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 2017-04-18 下午12:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        // 可以对Set集合中的数据进行指定顺序的集合排序，是不同步的
        TreeSet treeSet = new TreeSet();
        treeSet.add("abc");
        treeSet.add("abcd");
        treeSet.add("bcd");
        treeSet.add("efg");
        treeSet.add("ng");
        treeSet.add("bg");
        treeSet.add("hh");
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        demo();
    }

    private static void demo() {
        // 以Person对象的年龄从小到大进行排序
//        TreeSet treeSet = new TreeSet();
        // Person本身具备比较的功能，而集合中又含有比较器，但是以比较器为主
        TreeSet treeSet = new TreeSet(new CompareByName());
        treeSet.add(new Person("zhansan", 23));
        treeSet.add(new Person("lisi", 24));
        treeSet.add(new Person("wangwu", 25));
        treeSet.add(new Person("zhaoliu", 26));
        treeSet.add(new Person("tianqi", 27));
        treeSet.add(new Person("huba", 28));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            System.out.println(person.toString());
        }
    }
}
