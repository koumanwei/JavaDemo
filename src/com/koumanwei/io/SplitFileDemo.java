package com.koumanwei.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 文件切割器
 * 2017-04-21 上午11:48
 *
 * @author koumanwei
 * @version 1.0
 */
public class SplitFileDemo {
    private static final int BUFF_SIZE = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        splitFile();
        mergeFile();
    }

    /**
     * 切割文件
     *
     * @throws IOException
     */
    private static void splitFile() throws IOException {
        // 用流读取流关联源文件
        FileInputStream fis = new FileInputStream("/Users/koumanwei/Desktop/hello.zip");
        // 定义一个1兆的缓冲区
        byte[] buf = new byte[BUFF_SIZE];
        // 创建目的
        FileOutputStream fos = null;
        int len;
        int i = 1;
        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream("/Users/koumanwei/Desktop/hello/" + i++ + ".part");
            fos.write(buf, 0, len);
        }
        fis.close();
        fos.close();
    }
    private static void mergeFile() throws IOException {
        ArrayList<FileInputStream> al = new ArrayList<>();
        for (int i = 1; i <= 170; i++) {
            al.add(new FileInputStream("/Users/koumanwei/Desktop/hello/" + i + ".part"));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        FileOutputStream fos = new FileOutputStream("/Users/koumanwei/Desktop/hello/hello.zip");
        byte[] buf = new byte[1024];
        int len;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        sis.close();
        fos.close();
    }
}
