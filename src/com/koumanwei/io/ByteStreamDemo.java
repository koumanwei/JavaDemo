package com.koumanwei.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
	public static void main(String[] args) throws IOException {
		read();
	}

	public static void write() throws IOException {
		// 1、创建字节输出流对象。用于操作文件
		FileOutputStream fileOutputStream = new FileOutputStream("G:/kkk.txt");
		// 2、写数据，直接写入到了目的地中
		fileOutputStream.write("abcdeft".getBytes());
		// 注意：字节流不需要flush，因为不是字符流，不需要临时存储到缓冲区，直接操作的源码
		fileOutputStream.close();
	}

	public static void read() throws IOException {
		// 1、创建一个字节读取流和制定的文件相关联
		FileInputStream fileInputStream = new FileInputStream("G:/kkk.txt");
		// 2、一次读取一个字节，一个中文是两个字节
		// int ch = 0;
		// while ((ch = fileInputStream.read()) != -1) {
		// System.err.println((char) ch);
		// }
		System.out.println("文件大小：" + fileInputStream.available() + "字节");
		byte[] buf = new byte[2];
		int len = 0;
		while ((len = fileInputStream.read(buf)) != -1) {
			System.err.println(new String(buf, 0, len));
			// 这个是获取文件的大小，注意这里是获取到的还没有读取的文件的大小
			// 所以用此方法获取文件的大小时，次方法应该写在文件的读取之前
			System.out.println("文件大小：" + fileInputStream.available() + "字节");
		}
		fileInputStream.close();
	}
}
