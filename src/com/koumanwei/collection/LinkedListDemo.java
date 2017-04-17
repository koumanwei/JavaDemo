package com.koumanwei.collection;

import java.util.LinkedList;

/**
 * 2017-04-17 下午1:56
 *
 * @author koumanwei
 * @version 1.0
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("abc1");
        linkedList.addFirst("abc2");
        linkedList.addFirst("abc3");
        linkedList.addFirst("abc4");
        linkedList.addFirst("abc5");
        linkedList.addLast("abc6");
        linkedList.addLast("abc7");
        linkedList.addLast("abc8");
        System.out.println(linkedList);
        // 获取但不删除
        System.out.println(linkedList.getFirst());
        // 获取并删除
        System.out.println(linkedList.removeFirst());
//        Iterator iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
    }
}
