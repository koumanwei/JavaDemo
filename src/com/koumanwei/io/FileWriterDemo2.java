package com.koumanwei.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 extends FileWriterDemo {
	/**
	 * 获取不同系统中的换行符
	 */
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		// 需求：想要来个续写，该构造一创建，就会覆盖已有的文件
		FileWriter fileWriter = new FileWriter("/Users/koumanwei/Desktop/demo.txt", true);
		fileWriter.write("hahahahahahah" + LINE_SEPARATOR + "nihaoshijie");
		fileWriter.close();
		// 可以使用另一个构造函数，加入一个boolean指示是否续写
	}
}
