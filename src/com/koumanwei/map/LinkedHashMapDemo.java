package com.koumanwei.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 有序的Map
 * 2017-04-19 上午11:50
 *
 * @author koumanwei
 * @version 1.0
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(8, "赵六");
        linkedHashMap.put(7, "李三");
        linkedHashMap.put(9, "王五");
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
