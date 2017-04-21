package com.koumanwei.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 2017-04-21 上午9:55
 *
 * @author koumanwei
 * @version 1.0
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // PrintStream
        // 1、提供了打印方法可以对多种数据类型进行打印，并保持数据的表示形式
        // 2、它不抛出IO异常
        // 3、构造函数接收三种类型的值

        // 字符串路劲
        // File对象
        // 字节输出流

        PrintStream out = new PrintStream("/Users/koumanwei/Desktop/print.txt");
        // 文件中是 a 只写最低八位
        out.write(610);
        // 文件中是 97 将97先变成字符串保持原样数据打印到目的地
        out.print(97);
    }
}