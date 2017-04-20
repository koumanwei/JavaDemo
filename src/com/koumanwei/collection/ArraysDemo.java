package com.koumanwei.collection;

import java.util.Arrays;
import java.util.List;

/**
 * 2017-04-20 下午12:53
 *
 * @author koumanwei
 * @version 1.0
 */
public class ArraysDemo {
    public static void main(String[] args) {
        /**
         * Arrays：集合框架的工具类，里面的方法都是静态的
         */
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        /**
         * 将数组转成集合 重点
         * 好处：其实可以使用集合的方法操作数组中的元素
         * 注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的，否则会发生异常
         */
        List<String> list = Arrays.asList(arr);
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5", "6");
        System.out.println(list);
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        // 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行存储
        // 如果数组中的元素是基本数据类型，那么会将该数组作为集合中的元素进行存储
        // 集合只能存引用类型数据
        List<int[]> asList = Arrays.asList(array);
    }

    /**
     * Arrays的toString方法源码
     *
     * @param a
     * @return
     */

    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        // 中间省略了条件判断，提高了效率
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

}
