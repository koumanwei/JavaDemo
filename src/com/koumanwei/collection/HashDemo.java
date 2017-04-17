package com.koumanwei.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 2017-04-17 下午5:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class HashDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        // 哈希表确定元素是否相同
        // 1、判断的是两个元素的哈希值是否相同
        // 如果相同，再判断两个对象的内容是否相同
        // 2、判断哈希值相同，其实判断的是对象的hashCode方法
        // 判断内容是否相同，用的是equals方法
        // 注意：如果哈希值不同，是不需要判断equals的
        hashSet.add("haha");
        hashSet.add("xixi");
        hashSet.add("heihei");
        hashSet.add("hehe");
        hashSet.add("hehe");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
