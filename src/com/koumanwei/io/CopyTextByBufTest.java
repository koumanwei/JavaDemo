package com.koumanwei.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBufTest {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("G:/buf.txt");
		FileWriter fileWriter = new FileWriter("G:/buf2.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		// String line = null;
		// while ((line = bufferedReader.readLine()) != null) {
		// // 这个方法是往缓冲区写
		// bufferedWriter.write(line);
		// bufferedWriter.newLine();
		// bufferedWriter.flush();
		// }
		int ch = 0;
		while ((ch = bufferedReader.read()) != -1) {
			bufferedWriter.write(ch);
		}
		bufferedReader.close();
		bufferedWriter.close();
	}
}
