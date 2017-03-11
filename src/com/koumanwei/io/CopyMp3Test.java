package com.koumanwei.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp3Test {
	public static void main(String[] args) throws IOException {
		// copy1();
		copy2();
	}

	private static void copy2() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("G:/jilejingtu.mp3");
		FileOutputStream fileOutputStream = new FileOutputStream("G:/jilejingtu4.mp3");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		int ch = 0;
		while ((ch = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(ch);
		}
		// 其实下面这种方式是多余的，因为已经使用了缓冲了
		// byte[] buf = new byte[1024];
		// int len = 0;
		// while ((len = bufferedInputStream.read(buf)) != -1) {
		// fileOutputStream.write(buf, 0, len);
		// }
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}

	private static void copy1() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("G:/jilejingtu.mp3");
		FileOutputStream fileOutputStream = new FileOutputStream("G:/jilejingtu2.mp3");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fileInputStream.read(buf)) != -1) {
			fileOutputStream.write(buf, 0, len);
		}
		fileInputStream.close();
		fileOutputStream.close();
	}
}
