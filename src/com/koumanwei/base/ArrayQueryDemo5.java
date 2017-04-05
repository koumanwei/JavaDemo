package com.koumanwei.base;

/**
 * 2017-04-05 上午9:32
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayQueryDemo5 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseArray(arr);
        for (int i :
                arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 对给定的数组中的元素进行反转
     * 思路：1、反转其实就是头尾角标的元素进行位置的置换
     * 2、然后让头角标自增，尾角标自减，再继续位置置换
     * 3、一次类推，直到头角标和尾角标相等时结束
     */
    private static void reverseArray(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
