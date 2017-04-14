package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.List;

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

    }
}
