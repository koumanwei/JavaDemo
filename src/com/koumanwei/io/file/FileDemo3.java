package com.koumanwei.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDemo3 {
	public static void main(String[] args) throws IOException {
		File in = new File("G:\\nihao");
		File out = new File("E:\\shijie");
		copyFolder(in, out);
//		copyFile("g:/nihao/abd.txt","e:/aaa/adb.txt");
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
	public static void copyFolder(File src, File dest) throws IOException {  
	    if (src.isDirectory()) {  
	        if (!dest.exists()) {  
	            dest.mkdir();  
	        }  
	        String files[] = src.list();  
	        for (String file : files) {  
	            File srcFile = new File(src, file);  
	            File destFile = new File(dest, file);  
	            // 递归复制  
	            copyFolder(srcFile, destFile);  
	        }  
	    } else {  
	    	FileInputStream fileInputStream = new FileInputStream(src);
			System.out.println("拷贝文件源路径：" + src.getPath());
			FileOutputStream fileOutputStream = new FileOutputStream(dest.getPath());
			System.out.println("拷贝的文件的目标路径：" + dest.getPath());
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
