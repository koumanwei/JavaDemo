package com.koumanwei.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
	public static void main(String[] args) throws IOException {
		// 需求：演示Reader中的read(char[])
		// 文件中有abcde
		FileReader fileReader = new FileReader("/Users/koumanwei/Desktop/demo.txt");
		// 创建一个字符数组
		// 一个字符占两个字节
		// 建议设置为1024或者1024的倍数
		// 这种读取的效率比读取单个字符高很多，因为减少了循环的次数，减少了读取的次数
		char[] buf = new char[2];
		// 将读取到的字符存储到数组中，返回的是读取到的字符数量，返回-1代表读取结束
		// int len = fileReader.read(buf);
		// System.out.println(len + ":" + new String(buf));
		// int len1 = fileReader.read(buf);
		// System.out.println(len1 + ":" + new String(buf));
		// int len2 = fileReader.read(buf);
		// // :ed
		// System.out.println(len2 + ":" + new String(buf));
		// int len3 = fileReader.read(buf);
		// // -1:ef
		// System.out.println(len3 + ":" + new String(buf));

		// 为什么最后是-1，还是会打印ef呢？
		// 是因为不断用这个字符数组去装读取到的字符，下一个读取到的
		// 字符会覆盖上次字符数组中的数据，当读取到最后，上一次字符数组中的数据还在

		// 那么，如何解决这个问题呢？
		// 因为每次读取到的字符数量是不确定的，所以打印读取到的长度就可以了
		// 也就是说，读取字符数组中的数据是读取0-length
		int length;
		while ((length = fileReader.read(buf)) != -1) {
			// 将字符数组转换成字符串
			System.out.print(new String(buf, 0, length));
		}
		fileReader.close();
	}
}
