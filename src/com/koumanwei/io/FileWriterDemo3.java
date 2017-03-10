package com.koumanwei.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
	public static void main(String[] args) {
		// io异常处理规范
		// 在try外创建流对象的引用
		// 在try内对流对象进行初始化
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("Users/koumanwei/Desktop/demo3.txt");
			fileWriter.write("abc");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 这里的if必须写上，因为，如果创建文件失败的时候，
			// fileWriter对象是null，那么去调用close方法的时候，就会报空指针异常，导致程序崩溃
			// 而且是一个每个流对象都要判断，一个一个调用close方法关闭
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
					// 相关的代码处理，比如说，将关闭失败的信息记录到日志文件中
					throw new RuntimeException("关闭流失败");
				}
			}
		}
	}
}
