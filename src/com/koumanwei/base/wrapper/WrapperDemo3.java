package com.koumanwei.base.wrapper;

import java.util.Arrays;

/**
 * 对一个字符串中的数值进行从小到大的排序
 * 2017-04-13 下午5:41
 *
 * @author koumanwei
 * @version 1.0
 */
public class WrapperDemo3 {
    private static final String SPACE_SEPARATOR = "";

    public static void main(String[] args) {
        String numStr = "20 13 -7 67 45 89";
        sortStringNumber(numStr);

    }

    private static void sortStringNumber(String numStr) {
        // 1、将字符串变成字符串数组
        String[] strArr = stringToArray(numStr);
        // 2、将字符串数组编程int数组
        int[] numArr = toIntArray(strArr);
        // 3、对int数组排序
        mySortArray(numArr);
        // 4、将排序后的int数组变成字符串
        String temp = arrayToString(numArr);
        System.out.println(temp);
    }

    private static String arrayToString(int[] numArr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numArr.length; i++) {
            if (i != numArr.length - 1) {
                sb.append(numArr[i] + SPACE_SEPARATOR);
            } else {
                sb.append(numArr[i]);
            }
        }
        return sb.toString();
    }

    private static void mySortArray(int[] numArr) {
        Arrays.sort(numArr);
    }

    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    private static String[] stringToArray(String numStr) {
        String[] strArr = numStr.split(SPACE_SEPARATOR);
        return strArr;
    }
}
