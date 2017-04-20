package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 2017-04-20 下午1:22
 *
 * @author koumanwei
 * @version 1.0
 */
public class ArraysDemo2 {
    public static void main(String[] args) {
        /**
         * 集合转成数组
         * 使用的就是Collection中的toArray方法
         * 集合转成数组：可以对集合中的元素操作的方法进行限定，不允许对其增删
         * 需要传入一个指定类型的数组，如果长度小于集合的size，那么该方法会创建一个同类型并和集合相同的size的数组
         * 如果长度大于集合的size，所以长度建议默认为集合的size
         */
        List<String> list = new ArrayList();
        list.add("世界");
        list.add("你好");
        list.add("大家");
        list.add("朋友");
        String[] strings = list.toArray(new String[list.size()]);
//        System.out.println(Arrays.toString(strings));

        // jdk1.5之后，foreach
        // 格式：
        // for(类型 变量:Collection集合或者数组){}
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 4));
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(add(1, 2, 3, 4, 5, 6, 9));
        System.out.println(add(arr));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int add1(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    /**
     * 函数的可变参数，其实就是一个数组
     * 但是接收的是数组的元素，自动将这些元素封装成数组，简化了调用者的书写
     *
     * @param arr
     * @return
     */
    public static int add(int... arr) {
        int sum = 0;
        for (int i :
                arr) {
            sum += i;
        }
        return sum;
    }

    /**
     * 注意事项：可变参数类型必须定义在参数列表的结尾处
     *
     * @param a
     * @param arr
     * @return
     */
    public static int add(String a, int... arr) {
        int sum = 0;
        for (int i :
                arr) {
            sum += i;
        }
        return sum;
    }
}
