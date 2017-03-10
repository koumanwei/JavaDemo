package com.koumanwei.io;

import java.io.FileWriter;
import java.io.IOException;

// 字符流的由来：
// 其实就是：字节流读取文字字节数据之后，不直接操作而是先查指定的编码表
// 获取对应的文字，再对这个文字进行操作，简单说：字节流+编码表=字符流

// 输入流和输出流是相对于内存设备而言的
// 将外设中的数据读取到内存中：输入
// 将内存中的数据写入外设中：输出

// 字节流的两个顶层父类
// 1、InputStream 2、outputStream
// 字符流的两个顶层父类
// 1、Reader 2、Writer
// 这些体系的子类几乎都是以父类的名字作为后缀
// 而且子类的名字的前缀就是该对象的功能

// 需求：将一些文字存储到硬盘的一个文件中
// 如果要操作文字数据，优先考虑字符流，而且要将数据从内存写到硬盘上，Writer
// 硬盘的数据基本体现是文件，希望可以找到一个操作文件的Writer
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		// 创建一个可以往文件中写入字符流数据的字符输出流对象
		// 如果文件存在，就会覆盖，如果不存在，会自动创建
		// 如果不指定路径，而是就一个文件名，那么就会在该工程的根目录下创建文件，即使JavaDemo
		// 根目录下
		// 上面执行完以后，就会生成demo.txt文件，但是文件中没有数据
		FileWriter fileWriter = new FileWriter("G:\\demo.txt");
		// 其实数据写入到了临时存储区中
		fileWriter.write("你好");
		// 将数据直接写入目的地，可用多次，可类比windows中记事本的save方法
		fileWriter.flush();
		// 关闭资源，此方法默认调用flush方法，关闭之后就不能写入数据了
		// 可类比windows中关闭记事本窗口，关闭之前会提示让你保存
		fileWriter.close();
	}
}