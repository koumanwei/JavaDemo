package com.koumanwei.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransStreamDemo3 {
	public static void main(String[] args) throws IOException {
		// 将一个中文字符串数据按照指定的编码表写入到文件中
		// method();
		// method1();
		method2();
		method3();
		method4();
	}

	// 写入字符的时候，此对象会按照平台默认的字符编码进行编码
	// Windows的系统是GBK java内置的就是unicode码表
	// 字符类数据java使用的就是unicode码表，但解析中文字符串用的是GBK
	private static void method() throws IOException {
		FileWriter fileWriter = new FileWriter("G:/gbk.txt");
		fileWriter.write("你好");
		fileWriter.close();
	}

	private static void method1() throws IOException {
		// 下面这句代码和上面的代码是等同的
		// FileWriter：其实就是转换流指定了本机默认编码表的体现
		// 而且这个转换流的子类兑现可以方便操作文本文件
		// 这是按照默认编码表来造作文件的便捷类
		// 如果操作文本文件，需要名且具体的编码，FileWriter就不行了
		// 就必须用转换流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("G:/gbk2.txt"));
		outputStreamWriter.write("你好");
		outputStreamWriter.close();
	}

	/**
	 * 使用UTF-8存储数据到文件中
	 * 
	 * @throws IOException
	 */
	private static void method2() throws IOException {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("G:/gbk3.txt"), "UTF-8");
		outputStreamWriter.write("你好");
		outputStreamWriter.close();
		// 注意：上面按照GBK编码写入的文件时4个字节
		// 而这个UTF-8写入的是6个字节
		// 因为UTF-8一个中文对应3个字节
		// GBK对应的是2个
	}

	/**
	 * 用UTF-8读取UTF-8写入的中文字符串
	 * 
	 * @throws IOException
	 */
	private static void method3() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("G:/gbk3.txt"), "UTF-8");
		char[] buf = new char[10];
		int len = inputStreamReader.read(buf);
		String string = new String(buf, 0, len);
		System.out.println(string);
		inputStreamReader.close();
	}

	/**
	 * 用GBK读取UTF-8写入的中文字符串
	 * 
	 * @throws IOException
	 */
	private static void method4() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("G:/gbk3.txt"), "GBK");
		char[] buf = new char[10];
		int len = inputStreamReader.read(buf);
		String string = new String(buf, 0, len);
		System.out.println(string);
		inputStreamReader.close();
		// 浣犲ソ
		// 这是读取的结果
		// 如果出现中文，那一定是用GBK编码区读取了别的编码的字符
		// 因为一个中文字符在UTF-8中时三个字节，GBK是两个字节，
		// 所以读出来时三个字
		// 而如果用UTF-8区读取GBK编码的字符串，就全是问号因为找不到与之对应的文字
	}
}
