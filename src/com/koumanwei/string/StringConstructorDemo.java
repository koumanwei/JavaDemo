package com.koumanwei.string;

public class StringConstructorDemo {
	public static void main(String[] args) {
		stringConstructor2();
	}

	private static void stringConstructor() {
		// 等效于String string = "";不等效于 String string = null;
		String string = new String();
		byte[] arr = { 65, 66, 67, 68 };
		String string2 = new String(arr);
		System.out.println(string2);
	}

	private static void stringConstructor2() {
		char[] arr = { 'w', 's', 't', 'y' };
		String string = new String(arr);
		System.out.println(string);
	}
 
}
