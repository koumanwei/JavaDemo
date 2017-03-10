package com.koumanwei.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		// 需求：读取一个硬盘上的文本文件，将数据打印到控制台上
		// 思路：
		// 1、读取无非就是讲硬盘上的数据弄到内存中，要使用输入流。
		// 2、既然是文件，可以使用字符流，综合，使用字符输入流，该体系是Reader
		// 3、既然是读取文本文件，可以使用FileWriter，用于读取字符文件的便捷类

		FileReader fileReader = null;
		// 通过FileReader和指定的文件相关联，此文件可能不存在，FileNotFoundException是io异常的子类
		// 读取文件不存在flush功能
		fileReader = new FileReader("/Users/koumanwei/Desktop/demo.txt");
		// 一次读取一个字符，返回改字符对应的数字，返回-1，代表读取到了末尾
		// int ch = fileReader.read();
		// fileReader.close();
		// System.out.println("ch=" + ch);

		// 代码使用循环就解决了多次读取的问题，不用每次都读取一个字符
		int ch;
		while ((ch = fileReader.read()) != -1) {
			System.out.println((char) ch);
		}
	}
}
