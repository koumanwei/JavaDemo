package com.koumanwei.io;

import java.io.IOException;
import java.io.InputStream;

public class ReadKey {
	public static void main(String[] args) throws IOException {
		// 读取一个键盘录入的的数据，并打印在控制台上
		// 键盘本身就是一个标准的输入设备
		// 对于java而言，对于这种设备都有对应的对象

		// readKey();
		readKey2();
	}

	private static void readKey2() throws IOException {
		// 获取用户键盘录入的数据
		// 并将数据变成大写显示在控制台上
		// 如果用户输入的是over结束键盘录入

		// 思路：
		// 因为键盘读取只读取一个字节
		// 要判断是否是over，需要将读取到的字节拼接成字符串
		// 那就需要一个容器StringBuilder
		// 在用户回车之前，将用户录入的数据变成字符串判断即可

		// 1、创建容器
		StringBuilder stringBuilder = new StringBuilder();
		// 2、获取键盘读取流
		InputStream inputStream = System.in;
		// 3、定义变量记录读取到的字节，并循环获取
		int ch = 0;
		while ((ch = inputStream.read()) != -1) {
			// 在存储之前需要判断是否是换行标记，因为换行标记不存
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				String temp = stringBuilder.toString();
				// 清空上次缓存
				stringBuilder.delete(0, stringBuilder.length());
				if ("over".equals(temp)) {
					break;
				}
				System.out.println(temp.toUpperCase());
			} else {
				stringBuilder.append((char) ch);
			}
		}
	}

	private static void readKey() throws IOException {
		InputStream inputStream = System.in;
		// 阻塞式的方法
		int ch = inputStream.read();
		System.out.println(ch);
		// 这两个表示一次换行
		// System.out.println((int) '\r');
		// System.out.println((int) '\n');
		// 次流不需要关闭
	}
}
