package com.koumanwei.collection;

import com.koumanwei.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 定义功能取出ArrayList中重复的元素
 * 2017-04-18 上午11:08
 *
 * @author koumanwei
 * @version 1.0
 */
public class ArrayListTest2 {
    public static void main(String[] args) {
//        demo();
        singleDemo();
    }

    private static void singleDemo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Person("lisi1", 21));
        arrayList.add(new Person("lisi2", 21));
        arrayList.add(new Person("lisi3", 21));
        arrayList.add(new Person("lisi4", 21));
        arrayList.add(new Person("lisi5", 21));
        arrayList.add(new Person("lisi5", 21));
        System.out.println(arrayList);
        ArrayList singleElement = getSingleElement(arrayList);
        System.out.println(singleElement);
    }

    private static void demo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("abc1");
        arrayList.add("abc2");
        arrayList.add("abc3");
        arrayList.add("abc4");
        arrayList.add("abc5");
        arrayList.add("abc5");
        System.out.println(arrayList);
        System.out.println(getSingleElement(arrayList));
    }

    private static ArrayList getSingleElement(ArrayList arrayList) {
        // 定义一个临时容器
        ArrayList temp = new ArrayList();
        // 迭代要去除重复元素的容器
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            // 判断被迭代的元素是否在临时容器中存在
            if (!temp.contains(object)) {
                temp.add(object);
            }
        }
        return temp;
    }
}
