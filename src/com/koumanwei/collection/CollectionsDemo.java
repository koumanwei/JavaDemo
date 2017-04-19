package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 2017-04-19 下午2:19
 *
 * @author koumanwei
 * @version 1.0
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        // Collections是集合框架的工具类
        // 里面的方法都是静态的
        demo1();
    }

    private static void demo1() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("womsd");
        list.add("gbnsdgfsg");
        list.add("gb");
        list.add("g");
        list.add("gbndd");
        list.add("dded");
        list.add("hjiddd");
//        System.out.println(list);
//        可以排序，还可以元素重复
//        Collections.sort(list);
//        System.out.println(list);
        mySort1(list);
        System.out.println(list);
    }

    /**
     * 这个方法只能用于String类型的排序
     *
     * @param list
     */
    public static void mySort(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    /**
     * 只有实现了Comparable的子类才具有compareTo方法，所以用到了泛型的上限
     * 注意?表示T的父类
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mySort1(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
//                    这里也可以被T的父类接收，所以Comparable后面加上了泛型的下限来提高程序的扩展性
//                    T temp = list.get(i);
//                    list.set(i, list.get(j));
//                    list.set(j, temp);
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static <T> void mySort2(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    class ComparatorByLength implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int temp = o1.length() - o2.length();
            return temp == 0 ? o1.compareTo(o2) : temp;
        }
    }
}
