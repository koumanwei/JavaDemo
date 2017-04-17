package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 2017-04-14 下午4:45
 *
 * @author koumanwei
 * @version 1.0
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        show(list);
    }

    public static void show(List list) {
        // 添加元素
        list.add("abc0");
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            // java.util.ConcurrentModificationException
//            Object object = iterator.next();
//            if (object.equals("abc2")) {
//                // 因为在迭代的同时又去操作元素，就会引发异常，所以应该都有迭代器的方法，用ListIterator
//                list.add("abc9");
//            } else {
//                System.out.println(list);
//            }
//            System.out.println(object);
//        }
        // Set没有这种取出方式，Set只有iterator
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        // 它可以实现在迭代过程中完成对元素的增删改查
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (object.equals("abc2")) {
                listIterator.add("abc9");
            }
        }
        System.out.println(list);
        // List的子类
        // Vector：内部是数组数据结构，是同步的（开发几乎不用），增删查询都很慢
        // ArrayList：内部是数组数据结构，不是同步的，替代Vector，效率高，查询的速度快
        // LinkList：内部是链表结构，不是同步，增删元素的速度很快，因为空间是连续的

    }
}
