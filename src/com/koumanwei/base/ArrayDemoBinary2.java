package com.koumanwei.base;

/**
 * 2017-04-05 下午1:31
 *
 * @author koumanwei
 * @version 1
 */
public class ArrayDemoBinary2 {
    public static void main(String[] args) {
        toOctal(48);
    }

    /**
     * 打印数字对应的二进制、八进制、十六进制对应的表现形式
     *
     * @param num
     * @param base   右移位数对应的数字大小 二进制对应1 八进制对应7 十六进制对应15
     * @param offset 右移的位数 二进制对应1 八进制对应3 十六进制对应4
     */
    public static void trans(int num, int base, int offset) {
        if (num == 0) {
            System.out.println(0);
            return;
        }
        char[] arr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] chs = new char[32];
        int pos = chs.length - 1;
        while (num != 0) {
            int temp = num & base;
            chs[pos] = arr[temp];
            num = num >>> offset;
            pos--;
        }
        for (int i = pos + 1; i < chs.length; i++) {
            System.out.print(chs[i]);
        }
    }

    /**
     * 十进制转为二进制
     *
     * @param num
     */
    public static void toBin(int num) {
        // 对应java api提供的方法是
        Integer.toBinaryString(num);
        trans(num, 1, 1);
    }

    /**
     * 十进制转为八进制
     *
     * @param num
     */
    public static void toOctal(int num) {
        // 对应java api提供的方法是
        Integer.toOctalString(num);
        trans(num, 7, 3);
    }

    /**
     * 十进制转为二进制
     *
     * @param num
     */
    public static void toHex(int num) {
        // 对应java api提供的方法是
        Integer.toHexString(num);
        trans(num, 15, 4);
    }
}
