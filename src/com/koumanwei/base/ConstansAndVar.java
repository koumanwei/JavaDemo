package com.koumanwei.base;

/**
 * 常量和变量
 * 2017-03-11
 *
 * @author koumanwei
 * @version 1
 */
public class ConstansAndVar {
    // 常量表示不能改变的值
    // Java中常量的分类:
    // 1、整数常量
    // 2、小数常量
    // 3、布尔常量
    // 4、字符常量（数字、字符、符号）用单引号标识
    // 5、字符串常量（用双引号标识）
    // 6、null常量

    // 进制
    // 以8个二进制为一个数据单元，这个单元称为字节
    // 八进制 三个二进制 必须以0开头
    // 十六进制 四个二进制 必须以0x(零和x,x大小写无所谓)

    // 负数的二进制
    // 将对应的证书的二进制进行取反（0变1，1变0），再+1
    // 例如-6的二进制
    // 整数是4个字节，32位
    // 所以数字6有32个二进制位 00000000 00000000 000110
    // 取反之后---》11111111 11111111 111001
    // +1 00000000 00000000 000001
    // 得到-6的二进制为 11111111 11111111 111010
    // 二进制以1开头的都是负数
    // -1的二进制每一位都是1

    /**
     * 变量的概念
     */
    // 内存中的一个存储区域
    // 该区域有自己的名称（变量名）和类型（数据类型）
    // 该区域的数据可以在同一类型范围内不断变化

    // 为什么要定义变量？
    // 用来不断的存放同一类型的常量，并可以重复使用

    // 定义变量的格式：
    // 数据类型 变量名 = 初始化值；
    // 当数据不确定时使用变量
}