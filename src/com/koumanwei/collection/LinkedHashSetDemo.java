package com.koumanwei.collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 有序并且唯一
 * 2017-04-18 下午12:54
 *
 * @author koumanwei
 * @version 1.0
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("abc1");
        linkedHashSet.add("abc2");
        linkedHashSet.add("abc3");
        linkedHashSet.add("abc4");
        linkedHashSet.add("abc5");
        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
