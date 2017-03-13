package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo2 {
	public static void main(String[] args) throws IOException {
		// 从键盘上读取数据，并打印在控制台上
		// method();
		// method2();
		// method3();
		// method4();
		method5();
	}

	private static void method() throws IOException {
		// 1、获取键盘的录入，数据源
		InputStream inputStream = System.in;
		// 2、为了处理文件数据方便，将字节数据转换为字符数据，这个功能在转换流中，InputStreamReader
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// 3、为了提供读取的效率，使用缓冲区
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// 4、打印到显示器上，目的
		OutputStream outputStream = System.out;
		// 5、因为要打印到显示器上的数据都是文字数据，所以必须将这些文字数据转成字节数据
		// 而具备这个功能的对象是OutputStreamWriter
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		// 6、为了提供写入的效率，使用了缓冲区
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		// 7、频繁的读写操作
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			// 换行
			bufferedWriter.newLine();
			// 刷入数据，刷入字符数据的时候要加入刷新动作
			// 使用了缓冲区就一定要刷新
			bufferedWriter.flush();
			// 因为是从System中获取的流，可以不关闭流，随着系统的结束而结束
		}
	}

	/**
	 * 这个方法是上面的这个方法的简写
	 * 
	 * @throws IOException
	 */
	private static void method2() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}

	/**
	 * 将键盘录入的数据写入文件中
	 * 
	 * @throws IOException
	 */
	private static void method3() throws IOException {
		// 分析：
		// 相对于方法2来说，无非就是目的变了，目的变成了文件
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// 操作文件的有两个类，一个是字节流的FileOutputStream，一个是字符流的FileWriter
		// 但是这个地方需要的是字节流的对象
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("/Users/koumanwei/Desktop/abcd.txt")));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}

	/**
	 * 读取一个文件的内容，并打印在控制台上
	 * 
	 * @throws IOException
	 */
	private static void method4() throws IOException {
		// 分析：
		// 相对于方法2来说，无非就是源变了，源变成了文件
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/koumanwei/Desktop/abcd.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}

	/**
	 * 将一个文件中的数据写入到另一个文件中
	 * 
	 * @throws IOException
	 */
	private static void method5() throws IOException {
		// 分析：
		// 相对于方法4来说，无非就是目的变了，目的成了文件
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/koumanwei/Desktop/abcd.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("/Users/koumanwei/Desktop/abcd1.txt")));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			bufferedWriter.write(line.toUpperCase());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}
}
