package com.koumanwei.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IORule {
	// 在进行数据的操作时，io包中提供了N多种对象来操作
	// 在进行实际开发时，到底用哪个流对象来完成数据处理呢？
	// 这是我们最为苦恼的事情
	// 如何明确具体用哪个对象呢？

	// 通过以下规律就可以

	// 1、明确源和目的
	// 源：InputStream Reader 一定是被读取的
	// 目的：OutputStream Writer 一定是被写入的

	// 2、处理的数据是否是纯文本
	// 是：使用字符流 Reader Writer
	// 否：使用字节流 InputStream OutputStream

	// 如果源是纯文本，Reader
	// 如果目的是纯文本 Writer

	// 到这里，两个明确确定完，就可以明确使用哪个体系
	// 接下来，就要明确这个体系要使用哪个具体的对象

	// 3、明确数据所在的设备
	// 源设备：
	// 键盘 System.In
	// 硬盘 FileXXX
	// 内存 数组
	// 网络 Socket
	// 目的设备：
	// 显示器（控制台）System.Out
	// 硬盘 FileXXX
	// 网络 Socket

	// 到这里，使用哪个对象就可以明确了

	// 4、明确是否需要额外功能
	// 是否需要高效 Buffered
	// 是否需要转换 转换流
	// 后面会学到更多
	public static void main(String[] args) throws IOException {
		// method1();
		// method2();
		// method3();
		// method4();
		method5();
	}

	/**
	 * 复制一个文本文件
	 * 
	 * @throws IOException
	 */
	private static void method1() throws IOException {
		// 思路：
		// 1、明确源：
		// 源：InputStream Reader
		// 目的：OutputStream Writer
		// 2、是否是纯文本
		// 源：Reader
		// 目的：Writer
		// 3、明确具体设备
		// 源：硬盘 File
		// 设备：硬盘 File

		// 源对应的体系Reader中可以操作硬盘设备的对象是FileReader
		// 目的对应的Writer中可以操作硬盘设备对应的对象是FileWriter
		FileReader fileReader = new FileReader("/Users/koumanwei/Desktop/abcd.txt");
		FileWriter fileWriter = new FileWriter("/Users/koumanwei/Desktop/abcd3.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		// 读写操作
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		// 关流
		bufferedReader.close();
		bufferedWriter.close();
	}

	/**
	 * 复制一个图片
	 * 
	 * @throws IOException
	 */
	private static void method2() throws IOException {
		// 思路：
		// 1、明确源：
		// 源：InputStream Reader
		// 目的：OutputStream Writer
		// 2、是否是纯文本
		// 源：InputStream
		// 目的：OutputStream
		// 3、明确具体设备
		// 源：硬盘 File
		// 设备：硬盘 File
		// 4、需要额外功能 高效
		FileInputStream fileInputStream = new FileInputStream("/Users/koumanwei/Desktop/pic_guide2.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/koumanwei/Desktop/iiiiii.jpg");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 读写操作
		int ch = 0;
		while ((ch = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(ch);
		}
		// 关流
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}

	/**
	 * 读取键盘录入，存储到文件中
	 * 
	 * @throws IOException
	 */
	private static void method3() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("/Users/koumanwei/Desktop/iiii.txt")));
		// 读写操作
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		// 关流
		bufferedReader.close();
		bufferedWriter.close();
	}

	/**
	 * 读取一个文本，显示到显示器上
	 * 
	 * @throws IOException
	 */
	private static void method4() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/koumanwei/Desktop/demo222.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		// 读写操作
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}

	/**
	 * 读取一个文本文件，将文件中的文本按照指定的编码表utf-8写入到另一个文件中
	 * 
	 * @throws IOException
	 */
	private static void method5() throws IOException {
		// java内置的是unicode编码表
		// FileReader 和 FileWriter都使用了默认的编码表
		// 其实这两个对象就是字节流+默认的编码表
		// 而要求是按照默认的编码进行写入
		// 源对象不变
		FileReader fileReader = new FileReader("/Users/koumanwei/Desktop/demo222.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/koumanwei/Desktop/demo333.txt");
		// 字符流=字节流+编码表
		// 这时就要用到转换流，因为转换流可以指定编码表，需要往里传递字节流，而且是操作文件
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
		// 高效
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		// 读写操作
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		bufferedReader.close();
		bufferedWriter.close();
	}
}
