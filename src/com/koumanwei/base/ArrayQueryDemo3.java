package com.koumanwei.base;

/**
 * 2017-04-05 上午9:32
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayQueryDemo3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binarySearch(arr, 8);
        System.out.println(i);
    }

    /**
     * 二分查找法 也叫折半查找法，前提是数组是有序的
     *
     * @param arr
     * @return
     */
    private static int binarySearch(int[] arr, int key) {
        // 需要定义三个变量，记录角标的变化
        int min = 0, max, mid;
        max = arr.length - 1;
        while (min <= max) {
            // 获取中间角标
            mid = (min + max) / 2;
            // 获取中间角标上的元素，和key比较来确定min和max的新值
            // 或者叫做确定新的查找范围
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
