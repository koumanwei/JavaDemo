 package com.koumanwei.base;

/**
 * 2017-04-04 20:48
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayQueryDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 7};
        int index = getIndex(arr, 4);
        System.out.println(index);
    }

    /**
     * 数组的查找
     *
     * @param arr
     * @param key
     */
    private static int getIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
        // 里面的return有可能执行不到，所以外面必须增加return
        // 因为数组的角标没有-1，所以找不到的时候返回-1比较合适
    }
}
