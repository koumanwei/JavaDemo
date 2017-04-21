package com.koumanwei.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 2017-04-21 下午2:37
 *
 * @author koumanwei
 * @version 1.0
 */
public class SplitDemo2 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("/Users/koumanwei/Desktop/hello.zip");
        File desDir = new File("/Users/koumanwei/Desktop/partfiles");
//        splitFile(srcFile, desDir);
        mergeFile(desDir, desDir);
    }

    private static void splitFile(File srcFile, File desDir) throws IOException {
        // 判断目的文件夹
        if (!desDir.exists()) {
            desDir.mkdirs();
        }
        // 用流读取流关联源文件
        FileInputStream fis = new FileInputStream(srcFile);
        // 定义一个1兆的缓冲区
        byte[] buf = new byte[1024 * 1024];
        // 创建目的
        FileOutputStream fos;
        int len;
        int count = 1;
        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream(new File(desDir, count++ + ".part"));
            fos.write(buf, 0, len);
            fos.close();
        }
        Properties prop = new Properties();
        // 文件个数
        prop.setProperty("partcount", String.valueOf(count));
        // 文件名字
        prop.setProperty("filename", srcFile.getName());
        // 配置文件
        fos = new FileOutputStream(new File(desDir, count + ".properties"));
        // 将被切割文件的信息保存到文件中
        prop.store(fos, "");
        fis.close();
    }

    private static void mergeFile(File srcDir, File desDir) throws IOException {
        File[] files = srcDir.listFiles(new SuffixFilter(".properties"));
        if (files.length != 1) {
            throw new RuntimeException(srcDir + "，目录下没有properties扩展名的文件");
        }
        File configFile = files[0];
        // 获取该文件中的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(configFile);
        prop.load(fis);
        String fileName = prop.getProperty("filename");
        int count = Integer.parseInt(prop.getProperty("partcount"));
        // 获取该目录下的所有碎片文件

        File[] partFiles = srcDir.listFiles(new SuffixFilter(".part"));
        if (partFiles.length != (count - 1)) {
            throw new RuntimeException("碎片文件个数不正确");
        }
        ArrayList<FileInputStream> al = new ArrayList<>();
        for (int i = 0; i < partFiles.length; i++) {
            al.add(new FileInputStream(partFiles[i]));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        FileOutputStream fos = new FileOutputStream(new File(desDir, fileName));
        byte[] buf = new byte[1024];
        int len;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        sis.close();
        fos.close();
    }
}
