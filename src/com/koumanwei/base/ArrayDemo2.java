package com.koumanwei.base;

/**
 * 2017-04-03 21:39
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 32, 9};
        System.out.println(getMax(arr));
        System.out.println(getMax2(arr));
        System.out.println(getMax3(arr));
    }

    /**
     * 获取数组中的最大值
     */
    private static int getMax(int[] arr) {
        int max = 0;
        for (int x : arr) {
            max = x > max ? x : max;
        }
        return max;
    }
    // 注意这种写法，是用一个值，跟数据中的每个元素去比较，而不是用数据中的两个元素进行
    // 比较，把大的记录下来

    /**
     * 获取数组中的最大值
     */
    private static int getMax2(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    // 注意这种写法，是取出数组中第一个元素，跟着后面的以此比较

    /**
     * 获取数组中的最大值
     */
    private static int getMax3(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
    // 注意这种写法，是记录最大值的角标
}
