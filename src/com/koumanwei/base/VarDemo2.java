package com.koumanwei.base;

/**
 * 2017-03-30 下午5:56
 *
 * @author koumanwei
 * @version 1
 */
public class VarDemo2 {
    public static void main(String[] args) {
        byte b = 4;
        b = (byte) (b + 200);
        System.out.println(b);
        // 首先定义了一个byte的b，然后b+2，因为2是int类型，所以会发生类型向上提升，
        // 所以运算后的结果b+2会变成int类型，然后将这个数据存入b所在的存储区域中，
        // 因为b是byte，编译失败，所以强转一下
        // 如果换成是200，结果为204，不在byte的范围内-128~127
        // 因为int是4位，表示为00000000 00000000 00000000 11001100
        // 因为byte是一位，所以变成11001100
        // 因为是1开头的，所以这是一个负数，变成整数就是-1，再取反
        // 得到整数52，所以这个数是-52

        System.out.println((char) ('a' + 1));
        // 结果是b，字符本身有对应的数字，所以能做运算，字符占用两个字节，数字1占用4个字节，所以
        // 会发生自动类型提升，运算后的结果变成4个字节，强转成char得到b
        System.out.println("a" + 1);
        // 字符串和任何数据做+动作，都是相连接，生成一个新的字符串，所以这个结果a1
        System.out.println("5+5=" + 5 + 5);
        // 结果是5+5=55 其实是分别加了两个5
    }
}
