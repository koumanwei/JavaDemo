package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 2017-04-21 上午10:15
 *
 * @author koumanwei
 * @version 1.0
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        // 构造函数参数
        // 字符串路劲
        // File对象
        // 字节输出流
        // 字符输出流
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        // true代表自动刷新 所以不用flush方法
        PrintWriter out = new PrintWriter(System.out, true);
        String line;
        while ((line = buff.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            out.println(line);
        }
        out.close();
        buff.close();
    }
}
