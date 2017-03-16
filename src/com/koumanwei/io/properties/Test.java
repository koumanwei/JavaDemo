package com.koumanwei.io.properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws IOException {
		// 思考题：
		// 对指定目录的所有（包含子目录）的Java文件的绝对路径写入到一个文件中，这样
		// 查找某个Java文件会比较便捷，建立指定文件的清单

		// 思路：
		// 1、递归
		// 2、在递归过程需要过滤
		// 3、满足条件很多，需要容器存储
		// 4、将存储的文件绝对路径写入到一个文件中
		File dir = new File("/Users/koumanwei/GithubProjects/JavaDemo");
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		};
		List<File> list = new ArrayList<>();
		listAllJavaFile(dir, filter, list);
		// 常见一个目的地文件
		File file = new File(dir, "javalist.txt");
		Write2File(list, file);
	}

	// 定义功能对指定的目录进行递归
	// 在递归过程需要过滤
	// 而且对过滤条件满足的需要进行存储
	// 这个功能：
	// 对哪个目录进行递归不确定，设为参数
	// 目的不确定，设为参数
	// 过滤条件不确定，设为参数
	// 存储到哪里不确定，设为参数，
	// 其实是可以用集合存储的，但是不能放入函数中，因为递归过程会产生很多对象
	private static void listAllJavaFile(File dir, FilenameFilter filter, List<File> list) {
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					listAllJavaFile(file, filter, list);
				} else {
					// 如果是文件
					if (filter.accept(dir, file.getName())) {
						list.add(file);
					}
				}
			}
		}
	}

	/**
	 * 对集合中存储的内容的信息写入到文件中
	 * 
	 * @param list
	 * @param dest
	 * @throws IOException
	 */
	public static void Write2File(List<File> list, File dest) throws IOException {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(dest));
			for (File file : list) {
				bufferedWriter.write(file.getAbsolutePath());
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// 注意：这个方法是没有catch部分的，因为自己处理不了这个异常，
	// 写文件是调用者发起的，失败了应该怎么做，应该就给调用者处理
	// 但是必须有finally块来关闭资源
	// 因为调用者无法关闭
}
