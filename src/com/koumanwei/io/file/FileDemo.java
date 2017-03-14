package com.koumanwei.io.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		// fileConsDemo();
		// methodDemo_2();
		// methodDemo_3();
		methodDemo_4();
	}

	// File类
	// 用于描述系统中文件或者文件夹的对象
	// 可以用于操作文件或者文件夹的信息
	// 学习具体方法的使用，还是按照面向对象的原则
	// 如果将一个文件或者文件夹封装成对象，那么这个对象具备什么功能
	// 方便于对文件或者文件夹的操作呢？

	// 1、获取文件信息：
	// 获取名称
	// 获取路径
	// 获取大小
	// 获取时间
	// 2、判断
	// 是只读的不？
	// 是隐藏的不？
	// 3、文件的创建和删除以及该文件是否存在
	//

	/**
	 * 演示构造函数 file对象的创建
	 */
	private static void fileConsDemo() {
		// File中构造时，指定的路径可以是存在的，也可以是不存在的
		File file = new File("Users/koumanwei/Desktop/file.txt");
		File dir = new File("Users/koumanwei/Desktop/File");
		File file2 = new File("Users/koumanwei/Desktop/File", "file.txt");
		File dir2 = new File(dir, "file.txt");
		// 注意：Windows中用“\\”或者“/”都支持，但是linux不支持“\\”

		// 分隔符：
		// 路径分割符和名称分割符 都分别有char类型和String类型
	}

	/**
	 * file类方法显示
	 */
	private static void methodDemo_1() {
		File file = new File("Users/koumanwei/Desktop/file.txt");
		// 获取名称 file.txt
		String name = file.getName();
		// 获取绝对路径
		// /Users/koumanwei/GithubProjects/JavaDemo/Users/koumanwei/Desktop/file.txt
		String absPath = file.getAbsolutePath();
		// 获取父目录 Users/koumanwei/Desktop
		// 当前文件所在的父目录
		String dir = file.getParent();
		System.out.println("name:" + name);
		System.out.println("absPath:" + absPath);
		System.out.println("dir:" + dir);
	}

	private static void methodDemo_2() {
		File file = new File("/Users/koumanwei/Desktop/file.txt");
		// 文件大小是用字节来表示的，int不一定能装下
		long length = file.length();
		long length2 = file.getTotalSpace();
		System.out.println(length2);
	}

	private static void methodDemo_3() {
		File file = new File("/Users/koumanwei/Desktop/wenjian.apk");
		// 获取时间
		long lastModified = file.lastModified();
		// 将time转成Date对象，然后对Date进行格式化
		Date date = new Date(lastModified);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String str = dateFormat.format(date);
		System.out.println(str);
	}

	private static void methodDemo_4() throws IOException {
		File file = new File("/Users/koumanwei/Desktop/wenjian11.apk");
		// 1、创建
		boolean createNewFile = file.createNewFile();
		// 如果文件不存在，就创建，如果文件存在，就不创建。返回false
		// 而输出流会覆盖，如果不覆盖，需要在构造函数中加入true参数，续写
		// 2、删除
		boolean b = file.delete();
		boolean exists = file.exists();
		// 3、是否存在
		// 4、创建文件夹
		File dir = new File("/Users/koumanwei/Desktop/wenjian");
		// 创建一层目录
		boolean mkdir = dir.mkdir();
		File dirs = new File("/Users/koumanwei/Desktop/wenjian/a/b/c/d");
		// 创建多层目录 如果想创建d文件夹，如果前面的文件夹不存在，那么用mddir就会失败
		boolean mkdirs = dirs.mkdirs();
		// 删除文件夹，只会删除d，因为封装的只是d，而前面的是d所在的路径
		boolean delete = dirs.delete();

		// 注意：要判断file中封装的是文件还是目录，必须先判断文件存在
		// 文件重名名 会删除源文件

		File fileRename = new File("/Users/koumanwei/Desktop/wenjian1122.apk");
		file.renameTo(fileRename);
		// 返回系统根目录，windows就是有哪些盘
		File[] listRoots = File.listRoots();
		for (File file2 : listRoots) {
			System.out.println(file2);
		}
	}
}
