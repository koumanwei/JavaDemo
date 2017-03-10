package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("G:/buf.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			// 读取一行，行是文本数据特有的单位
			System.out.println(line);
		}
		bufferedReader.close();
	}
	// BufferWriter特有的方法是newLine()
	// BufferReader特有的方法是readLine()
	// 其实缓冲还有一个写入但是字符的read()方法，
	// 但是父类有一个read()，为什么还要自己有一个read()方法呢？
	// 其实缓冲区拿数据的时候，也就是说将数据弄到缓冲区的时候，就是用的父类的
	// read()方法。而缓冲区的read()方法，操作的数据时缓冲区。所以覆盖了
	// 父类的read()方法
	// 也就是说，这个方法是一个一个字符的从缓冲区读，其实已经高效了
	// 但是缓冲区提供了一个读取行的方法，这个会更高效，其实就是
	// 一个字符一个字符的读，然后放到一个临时的容器，判断换行标记，如果是，就终止，
	// 将标记之前的缓存数据变成字符串返回
	// 此时就是一行的数据，这个临时容器不包含换行符。
}
