package com.koumanwei.io;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("G:/buf.txt");
		MyBufferReader bufferedReader = new MyBufferReader(fileReader);
		String line = null;

		while ((line = bufferedReader.myReaderLine()) != null) {
			// 读取一行，行是文本数据特有的单位
			System.out.println(line);
		}
		bufferedReader.myClose();
	}
}
