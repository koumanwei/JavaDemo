package com.koumanwei.collection;

import java.util.LinkedList;

/**
 * 请使用LinkedList来模拟一个堆栈或者队列数据结构
 * 2017-04-17 下午3:18
 *
 * @author koumanwei
 * @version 1.0
 */
public class LinkedTest {
    public static void main(String[] args) {
        DuiLie duiLie = new DuiLie();
        duiLie.add("1");
        duiLie.add("2");
        duiLie.add("3");
        duiLie.add("4");

        while (!duiLie.isNull()) {
            System.out.println(duiLie.get());
        }
    }
    // 栈：先进后出 First in Last out FILO
    // 队列：先进先出 Fist in Fist out FIFO

    // 我们应该描述这样一个容器，给使用者提供一个容器对象，完成这两种结构中的一种
    static class DuiLie {
        private LinkedList linkedList;

        public DuiLie() {
            this.linkedList = new LinkedList();
        }

        public void add(Object obj) {
            linkedList.addLast(obj);
        }

        public Object get() {
            return linkedList.removeFirst();
        }

        public boolean isNull() {
            return linkedList.isEmpty();
        }
    }
    // LinkedList：

    // addFirst()
    // addLast()

    // jdk1.6以后变成了
    // offerFirst()
    // offerLast()

    // getFirst() 获取但不移除，如果链表为空，将会抛异常NoSuchElementException
    // getFirst()

    // jdk1.6以后变成了
    // peekFirst() 获取但不会移除，如果链表为空，返回null
    // peekLast()

    // removeFirst() 获取并移除，如果链表为空，将会抛异常NoSuchElementException
    // removeLast

    // jdk1.6以后变成了
    // pollFirst() 获并移除，如果链表为空，返回null
    // pollLast()
}
