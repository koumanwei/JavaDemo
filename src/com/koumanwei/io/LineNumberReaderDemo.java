package com.koumanwei.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("G:/buf.txt");
		LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
		String line = null;
		while ((line = lineNumberReader.readLine()) != null) {
			System.out.println(lineNumberReader.getLineNumber() + ":" + line);

		}
		lineNumberReader.close();
	}
}
