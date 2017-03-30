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
        b = (byte) (b + 2);
        System.out.println(b);
        // 首先定义了一个byte的b，然后b+2，因为2是int类型，所以会发生类型向上提升，
        // 所以运算后的结果b+2会变成int类型，然后将这个数据存入b所在的存储区域中，
        // 因为b是byte，编译失败，所以强转一下

    }
}
