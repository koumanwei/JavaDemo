package com.koumanwei.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 2017-04-21 下午5:16
 *
 * @author koumanwei
 * @version 1.0
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        // 该对象既能读，又能写
        // 该对象内部维护了一个大型byte数组
        // 可以通过getFilePoint方法或者指针的位置，和通过seek方法设置指针的位置
        writeFile();
        readFile();
    }

    // 使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄
    public static void writeFile() throws IOException {
        // 如果文件不存在，则创建，如果文件存在，不创建
        RandomAccessFile raf = new RandomAccessFile("/Users/koumanwei/Desktop/random.txt", "rw");
        raf.write("张三".getBytes());
        raf.writeInt(34);
        raf.close();
    }

    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("/Users/koumanwei/Desktop/random.txt", "r");
        byte[] buf = new byte[4];
        raf.read(buf);
        String name = new String(buf);
        String age = String.valueOf(raf.readInt());
        System.out.println(age);
        System.out.println(name);
        raf.close();
    }
}
