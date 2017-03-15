package com.koumanwei.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		File in = new File("/Users/koumanwei/Desktop/nihaoshijie");
		File out = new File("/Users/koumanwei/Desktop/kk");
		// showDir(dir);
		// deleteDir(dir);
		copyDir(in, out);
	}

	/**
	 * 获取指定目录中的所有内容（包含子目录）
	 * 
	 * @param dir
	 */
	private static void showDir(File dir) {
		if (!dir.isDirectory()) {
			return;
		}
		System.out.println("dir:" + dir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				// 递归调用 递归就是函数自身调用自身（直接或者间接）
				// 递归调用一定要注意条件
				// 当一个功能被复用，每次这个功能需要的参数都是上一次该功能的元素得出的
				showDir(file);
			} else {
				System.out.println("file" + file);
			}
		}
	}

	/**
	 * 删除一个带内容的文件夹（可以使用递归完成）
	 */
	private static void deleteDir(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				deleteDir(file);
			} else {
				// 删除文件
				file.delete();
			}
		}
		// for执行完以后，传进来的目录下的文件都会被删除，那么久应该删除了该目录
		// 删除目录
		dir.delete();
	}

	/**
	 * 复制文件或者文件夹
	 * 
	 * @throws IOException
	 */
	private static void copyFile(File in, File out) throws IOException {
		// 遍该目录下
		File[] files = in.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				// 递归调用
				File file = new File(out, f.getName());
				file.mkdirs();
				copyFile(f, file);
			} else {
				// 拷贝单个文件
				FileInputStream fileInputStream = new FileInputStream(f);
				FileOutputStream fileOutputStream = new FileOutputStream(out.getPath() + File.separator + f.getName());
				BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
				int ch = 0;
				while ((ch = bufferedInputStream.read()) != -1) {
					bufferedOutputStream.write(ch);
				}
				bufferedInputStream.close();
				bufferedOutputStream.close();
			}
		}
	}

	private static void copyDir(File in, File out) throws IOException {
		File file = new File(out, in.getName());
		if (!file.exists()) {
			file.mkdir();
		}
		copyFile(in, file);
	}
}
