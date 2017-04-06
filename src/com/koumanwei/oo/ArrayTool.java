package com.koumanwei.oo;

/**
 * 用于操作数组的工具类
 * 2017-04-06 下午3:28
 *
 * @author koumanwei
 * @version 1.0
 */
public class ArrayTool {
    // 因为该类没有封装特有数据
    // 也就是没有定义成员变量
    // 即使有成员变量，但是这个类中的方法没有访问成员变量
    // 所以该类中的方法就不必用对象调用
    // 这个类创建就没有什么意义
    // 为了防止别人new，所以将构造函数私有化
    private ArrayTool() {
    }

    /**
     * 获取数组的最大值
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] > arr[max]) {
                max = i;
            }
        }
        return arr[max];
    }

    /**
     * 获取数组的最小值
     *
     * @param arr
     * @return
     */
    public static int getMin(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] < arr[min]) {
                min = i;
            }
        }
        return arr[min];
    }
}
