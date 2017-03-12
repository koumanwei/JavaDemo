package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TransStreamDemo {
	public static void main(String[] args) throws IOException {
		// 字节流
		InputStream inputStream = System.in;
		// 转换流，将字节流转成字符流
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if ("over".endsWith(line)) {
				break;
			}
			System.out.println(line.toUpperCase());
		}
	}
}
