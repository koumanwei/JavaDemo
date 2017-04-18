package com.koumanwei.map;

import com.koumanwei.bean.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 2017-04-18 下午4:37
 *
 * @author koumanwei
 * @version 1.0
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 将学生对象和学生的归属地通过键与值存储到map集合中
        HashMap<Student, String> hashMap = new HashMap<Student, String>();
        hashMap.put(new Student("lisi", 13), "北京");
        hashMap.put(new Student("wangwu", 24), "黑龙江");
        hashMap.put(new Student("zhaoliu", 32), "河北");
        hashMap.put(new Student("tianqi", 22), "天津");
        hashMap.put(new Student("huba", 24), "上海");
        hashMap.put(new Student("huba", 24), "大连");
        Set<Student> students = hashMap.keySet();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key.getName() + " " + key.getAge() + " " + value);
        }
    }
}
