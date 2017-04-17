package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 2017-04-14 下午4:45
 *
 * @author koumanwei
 * @version 1.0
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        show(list);
    }

    public static void show(List list) {

        // List可以完成对元素的增删改查
        // 添加元素
        list.add("abc0");
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        // 插入元素
        list.add(3, "abc9");
        System.out.println(list);

        // 删除元素
        Object remove = list.remove(3); // 返回被删除的元素
        System.out.println(remove);
        // 修改元素
        Object a = list.set(2, "abc8"); // 返回被修改的元素
    }
}
// List：有序，存入和取出的顺序一致，元素都有索引（角标），元素可以重复
// Set：无序，元素不可以重复

// List特有的常见方法：
// 都可以操作角标

// 1、添加
