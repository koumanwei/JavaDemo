package com.koumanwei.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextTest {
	public static void main(String[] args) throws IOException {
		// 练习：复制一个文本文件到另外一个地方
		// 思路：
		// 1、要复制的文本文件是一个数据源，复制到的地方是存储的目的地，该目的中应该有一个文件。
		// 2、先读取源文件，将读取到的数据写入目的地中
		// 3、既然是操作文本文件，只要用字符流即可

		// 1、创建字符读取流和源文件关联
		FileReader fileReader = new FileReader("/Users/koumanwei/Desktop/demo.txt");
		// 2、创建字符流输出流对象，明确要存储数据的目的
		FileWriter fileWriter = new FileWriter("/Users/koumanwei/Desktop/demo222.txt");
		// 3、读写操作，读取一个，就写一个
		int ch;
		while ((ch = fileReader.read()) != -1) {
			// 这里不用强转为char，因为api中本身就提供这个写入单个字符的方法
			fileWriter.write(ch);
		}
		fileReader.close();
		fileWriter.close();
	}
}
