package com.koumanwei.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 自定义的读取缓冲区，其实就是模拟一个BufferReader
 * 
 */
// 分析：
// 缓冲区中无非就是封装了一个数组
// 并对外提供了更多的方法对数组进行访问
// 其实这些方法最终操作的都是数组的角标

// 缓冲区的原理：
// 其实就是从源中获取一批数据装进缓冲区中
// 再从缓冲区不断的取出一个一个数据
// 在此次取完之后，再从源中继续取一批数组进缓冲区
// 当源中的数组取光时，用-1作为结束标记
public class MyBufferReader {
	private FileReader fileReader;
	// 定义一个数组作为缓冲区
	private char[] buf = new char[1024];
	// 定义一个指针用于操作这个数组中的元素，当操作到最后一个元素后，指针应该归零
	private int pos = 0;
	// 定义一个计数器，用于记录缓冲区中数组的个数，当该数据减到0，就从源中继续取数组进缓冲区中
	private int count = 0;

	public MyBufferReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public int myRead() throws IOException {
		// 1、从源中获取一批数组到缓冲区中，只有计数器为0时，才从源中取数据
		if (count == 0) {
			count = fileReader.read(buf);
			// 每次获取数组到缓冲区后，角标归零
			pos = 0;
		}
		if (count < 0) {
			return -1;
		}
		// 从缓冲区中取取出一个数据
		char ch = buf[pos];
		pos++;
		count--;
		return ch;
	}

	public String myReaderLine() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		int ch = 0;
		while ((ch = myRead()) != -1) {
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				return stringBuilder.toString();
			}
			// 将从缓冲区读到的字符存储到缓存行数据的缓冲区中
			stringBuilder.append((char) ch);
			// 如果最后的数据后面没有回车符，那么就不会返回该数据
			// 但是数据已经进入了缓冲区了，只是没有返回而已
			// 所以加一层判断
		}
		if (stringBuilder.length() != 0) {
			return stringBuilder.toString();
		}
		return null;
	}

	public void myClose() throws IOException {
		fileReader.close();
	}
}
