package com.koumanwei.base.wrapper;

/**
 * 2017-04-13 下午5:41
 *
 * @author koumanwei
 * @version 1.0
 */
public class WrapperDemo {
    public static void main(String[] args) {
        // 基本数据类型对象包装类
        // 为了方便操作基本数据类型值，将其封装成了对象
        // 在对象定义中定义了属性和行为丰富了该数据的操作
        // 用于描述该对象的类就称为基本数据类型对象包装类

        // byte Byte
        // short Short
        // int Integer
        // long Long
        // float Float
        // char Character
        // boolean Boolean
        // double Double

        Integer num = 8;
        System.out.println(Integer.MAX_VALUE);
        // 基本类型---》字符串
        // 1、基本类型+""
        // 2、用String类中的静态方法valueOf(基本数据类型);
        // 字符床---》基本数据类型
        // 1、使用包装类中的静态方法xxx parseXxx("xxx类型的字符串");
        // 只有Character没有这个方法
        Integer.parseInt("123");
        Long.parseLong("2515425");
        Double.parseDouble("1.23");
        Boolean.parseBoolean("false");

    }
}
