package com.koumanwei.collection;

import com.koumanwei.bean.Person;

import java.util.Comparator;

/**
 * 创建了一个根据Person类的name进行排序的比较器
 * 2017-04-18 下午2:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class CompareByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        int temp = p1.getName().compareTo(p2.getName());
        return temp == 0 ? p1.getAge() - p2.getAge() : temp;
    }
}
