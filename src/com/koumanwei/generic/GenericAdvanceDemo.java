package com.koumanwei.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型限定_上限
 * 2017-04-18 23:24
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericAdvanceDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("nihao");
        arrayList.add("women");
        arrayList.add("dajia");

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(8);
        arrayList2.add(45);
        arrayList2.add(67);
        printCollection(arrayList);
        printCollection(arrayList2);
    }

    /**
     * 打印集合中的元素
     *
     * @param arrayList
     */
    private static void printCollection(Collection<?> arrayList) {
        Iterator<?> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    // 泛型的通配符？

    /**
     * 打印集合中的元素
     *
     * @param arrayList
     * @param <T>
     * @return
     */
    private static <T> T printCollection1(Collection<T> arrayList) {
        Iterator<T> iterator = arrayList.iterator();
        T t = iterator.next();
        return t;
    }
    // 这种用泛型方法和通配符的情况区别在于通配符不能接收
}
