package com.koumanwei.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/koumanwei/Desktop");
		// 将指定目录下的文件或者文件夹的（名称）存到字符串数组中，包含隐藏文件
		// 必须是一个已经存在目录
		// 过滤器只会搜索当前目录（文件名过滤器）
		String[] list = file.list(new FilterBySuffix(".java"));
		for (String string : list) {
			System.out.println(string);
		}
		// 将指定目录下的文件或者文件夹的名称存到字符串数组中，包含隐藏文件
		String[] lists = file.list();
		for (String string : lists) {
			System.out.println(string);
		}
		// 记住：这个方法返回当前目录下所有的文件和文件夹，并封装成File对象，而不仅仅是文件或者文件夹的名字
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			System.out.println(f);
		}
		// 过滤隐藏文件 就是把返回隐藏文件（使用的是文件过滤器）
		File[] hide = file.listFiles(new FilterByHidden());
		for (File f : hide) {
			System.out.println(f);
		}
	}
}
