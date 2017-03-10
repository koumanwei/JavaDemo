package com.koumanwei.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextTest2 {
	public static void main(String[] args) {
		// 复制文本文件，使用字符缓冲数组
		// 使用的就是可以操作数组的读写方法

		// 1、定义字符输入流和字符输出流的引用
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			// 2、对流对象初始化
			fileReader = new FileReader("/Users/koumanwei/Desktop/demo.txt");
			fileWriter = new FileWriter("/Users/koumanwei/Desktop/demo3333.txt");
			// 3、定义一个数组缓冲区，用于缓冲读取到的数据
			char[] buf = new char[1024];
			// 4、读写操作
			int len;
			while ((len = fileReader.read(buf)) != -1) {
				fileWriter.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
