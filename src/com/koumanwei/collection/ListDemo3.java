package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2017-04-14 22:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        show(list);
    }

    public static void show(List list) {
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        list.add("abc6");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
