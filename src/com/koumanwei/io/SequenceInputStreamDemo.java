package com.koumanwei.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 2017-04-21 上午11:10
 *
 * @author koumanwei
 * @version 1.0
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 将print1.txt print2.txt print3.txt合并到一个文件中
        FileInputStream is1 = new FileInputStream("/Users/koumanwei/Desktop/print1.txt");
        FileInputStream is2 = new FileInputStream("/Users/koumanwei/Desktop/print2.txt");
        FileInputStream is3 = new FileInputStream("/Users/koumanwei/Desktop/print3.txt");
        // 这个效率很低，所以用ArrayList
//        Vector<FileInputStream> vector = new Vector<>();
//        vector.add(is1);
//        vector.add(is2);
//        vector.add(is3);
//        Enumeration<FileInputStream> elements = vector.elements();

        ArrayList<FileInputStream> arrayList = new ArrayList<>();
        arrayList.add(is1);
        arrayList.add(is2);
        arrayList.add(is3);

        // 使用迭代器和枚举类搭配使用，但是也是麻烦
//        Iterator<FileInputStream> iterator = arrayList.iterator();
//        Enumeration<FileInputStream> elements = new Enumeration<FileInputStream>() {
//            @Override
//            public boolean hasMoreElements() {
//                return iterator.hasNext();
//            }
//
//            @Override
//            public FileInputStream nextElement() {
//                return iterator.next();
//            }
//        };
        Enumeration<FileInputStream> enumeration = Collections.enumeration(arrayList);
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        FileOutputStream fos = new FileOutputStream("/Users/koumanwei/Desktop/print4.txt");
        byte[] buf = new byte[2048];
        int len;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
}
