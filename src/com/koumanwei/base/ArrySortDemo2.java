package com.koumanwei.base;

/**
 * 2017-04-04 19:56
 *
 * @author koumanwei
 * @version 1
 */
public class ArrySortDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 3, 4, 5, 6, 7, 2, 9};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        // 为了减少元素换位置的次数，所以用一个变量记录最小值，用两外一个变量记录该最小值的索引
        // 这样只需要换一次位置
        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (num > arr[j]) {
                    num = arr[j];
                    index = j;
                }
            }
            if (i != index) {
                swap(arr, i, index);
            }
        }
    }

    /**
     * 给数组中的两个元素换位置
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
