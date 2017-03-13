package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {
	public static void main(String[] args) throws IOException {
		// method1();
		method2();
	}

	private static void method1() throws IOException {
		// 字节流
		InputStream inputStream = System.in;
		// 转换流，将字节流转成字符流
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			System.out.println(line.toUpperCase());
		}
	}

	private static void method2() throws IOException {
		// 输入流
		InputStream inputStream = System.in;
		// 转换流，将字节流转成字符流，这是读取流，这一步是明确源
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// 缓冲读取流
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// 输出流
		OutputStream outputStream = System.out;
		// 转换流，将字符流转换为字节流，这是写入流，这一步是明确目的
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		// 缓冲写入流
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			bufferedWriter.newLine();
			// 刷入数据，刷入字符数据的时候要加入刷新动作
			bufferedWriter.flush();
		}
		// 注意：正常说来，从System.In中读取数据的时候，一次只能读取一个字节，
		// 这对以abc这样的单字节可以，但是如果是汉字，一个汉字两个字符，所以，
		// 我们可以将读取到的字节先转为字符，所以使用了InputStreamReader来进行转换
		// 实际上是这个对象的read()方法进行转换的，现在已有的是字符流，所以用OutputStreamWriter来
		// 进行转换
	}
}
