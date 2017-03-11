package com.koumanwei.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {
	// 获取对应平台的换行符
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		FileWriter fileWriter = new FileWriter("G:/buf.txt");
		// 为了提高写入的效率，使用了字符流的缓冲区
		// 创建了一个字符流写入流的缓冲区对象，并和指定要被缓冲的流对象相关联
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		// 使用缓冲区的写入方法将数据写入到缓冲区中
		bufferedWriter.write("adbdef" + LINE_SEPARATOR + "你好");
		// 写入一个换行符，注意：newLine只是这个对象具有，不能代替上面的分隔符，而上面的换行符
		// 在任何地方都适用
		bufferedWriter.newLine();
		// 使用缓冲区的刷新方法，将数据刷入目的地中
		bufferedWriter.flush();
		// 关闭缓冲区，其实关闭的就是被缓冲的流对象
		// 缓冲区只是起到了缓冲的作用
		bufferedWriter.close();

		// 注意：使用了缓冲区之后，写入，刷数据，关闭流都是使用缓冲区的方法
		// 而且使用了缓冲区，就一定要使用flush方法
		// 不必调用fileWriter.close方法，
	}
}
