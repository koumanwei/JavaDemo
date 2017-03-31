package com.koumanwei.base;

/**
 * 2017-03-31 上午11:43
 *
 * @author koumanwei
 * @version 1
 */
public class VarDemo3 {
    public static void main(String[] args) {
        byte b1 = 3;
        // 其实就是将整数3赋给byte，编译器检查之后3在byte范围，所以不会报错
        byte b2 = 4;
        byte b;
        // b = b1 + b2;
        // 这里会报错，因为b1和b2是变量，所以他们相加的和可能大于byte的范围，
        b = 3 + 4;
    }
}
