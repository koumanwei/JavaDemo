package com.koumanwei.map;

import java.util.*;

/**
 * 2017-04-18 下午2:54
 *
 * @author koumanwei
 * @version 1.0
 */
public class MapDemo {
    public static void main(String[] args) {
        // Map：一次添加一对元素，也称为双列集合
        // Map集合必须保证键的唯一性
        // 常用方法

        // 1、添加：
        // value put(key,value)：返回前一个和key关联的值，如果没有返回null
        // 2、删除：
        // clear()
        // remove()，根据指定的键删除元素，返回被删除元素的值
        // 3、判断
        // containsKey()
        // containsValue()
        // isEmpty()
        // 4、获取：
        // value get(key)，如果没有该键，返回null
        // 当然可以同时返回null,判断是否包含指定键

        Map<Integer, String> map = new HashMap<>();
        demo(map);
    }

    private static void demo(Map<Integer, String> map) {
        System.out.println(map.put(8, "wangcai"));
        System.out.println(map.put(9, "xiaoqiang"));
        System.out.println(map.put(10, "zhongshan"));
        System.out.println(map);

        // 取出Map中所有的键，然后根据键取值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(map.get(key));
        }
        // 取出Map中所有的键值对
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> next = it.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println(key + " " + value);
        }
        // 获取所有的值
        Collection<String> values = map.values();
        Iterator<String> iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
    // Map常用的子类：
    // HashMap：内部结构是哈希表，是不同步的，注意，允许null作为键，null作为值
    // HashTable：内部结构是哈希表，是同步的，不允许null作为键，null作为值
    // TreeMap：内部结构二叉树，不是同步的，可以对Map集合中的键进行排序
}
