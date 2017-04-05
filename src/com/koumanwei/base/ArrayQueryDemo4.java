package com.koumanwei.base;

/**
 * 2017-04-05 上午9:32
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayQueryDemo4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    // 思考题：有一个有序的数组，要求如果往这个数组总添加一个元素，还能继续保证这个数组的有序
    // 那么这个元素的位置如何获取？
    private static int getInsertIndex(int[] arr, int key) {
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
        return min;
    }
}
