package com.koumanwei.map;

import com.koumanwei.bean.Student;
import com.koumanwei.collection.CompareByName;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 2017-04-18 下午4:53
 *
 * @author koumanwei
 * @version 1.0
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Student, String> TreeMap = new TreeMap<>(new CompareByName());
        TreeMap.put(new Student("lisi", 13), "北京");
        TreeMap.put(new Student("wangwu", 24), "黑龙江");
        TreeMap.put(new Student("zhaoliu", 32), "河北");
        TreeMap.put(new Student("tianqi", 22), "天津");
        TreeMap.put(new Student("huba", 24), "上海");
        TreeMap.put(new Student("huba", 24), "大连");
        Set<Student> students = TreeMap.keySet();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student key = iterator.next();
            String value = TreeMap.get(key);
            System.out.println(key.getName() + " " + key.getAge() + " " + value);
        }
    }
}
