package com.koumanwei.string;

/**
 * Created by koumanwei on 2017-03-19.
 */
public class StringBuilderDemo {
    // jdk1.5之后出现了功能和StringBuffer一样的类StringBuilder
    // StringBuilder速度更快，因为它线程不安全
    // 而StringBuffer线程是安全的
    // 所以StringBuffer通常用于多线程
    // StringBuilder用于单线程
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 6, 8};
        String s = arrayToString(arr);
        String s1 = arrayToString2(arr);
        System.out.println(s1);
    }

    private static String arrayToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                str += arr[i] + ",";
            } else {
                str += arr[i] + "]";
            }
        }
        return str;
    }

    /**
     * 记得，数据一多就用容器，而且第一个方法，每连接一次
     * 就会在字符串常量池中产生一个新的字符串
     *
     * @param arr
     * @return
     */
    private static String arrayToString2(int[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                sb.append(arr[i] + ",");
            } else {
                sb.append(arr[i] + "]");
            }
        }
        return sb.toString();
    }
}
