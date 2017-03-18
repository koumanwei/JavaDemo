package com.koumanwei.string;

public class StringMethodDemo {
	public static void main(String[] args) {
		// StringMethod1();
		// method2();
		method4();
	}

	/**
	 * 获取
	 */
	private static void StringMethod1() {
		String string = "abcdrgalkjdf";
		// 获取字符串的长度（个数）
		int lenth = string.length();
		// 根据位置获取字符
		char c = string.charAt(6);
		// 根据字符获取在字符串中第一次出现的位置
		int index = string.indexOf('d');
		// 从指定的位置获取字符第一次出现的的位置
		int index1 = string.indexOf("dr");
		// 获取字符最后一次出现的位置
		int lastIndex = string.lastIndexOf('k');
		String string2 = "";
		String string3 = " ";
		// 注意：string2不等于string3，因为空格是一个字符
		System.out.println(index);
		// 获取字符串中的一部分
		// 包括2位置上的字符，但是不包含6位置上的
		// 也就是说包含开始，但是不包含结束，长度为6-2
		String string4 = string.substring(2, 6);
		System.out.println(string4);
	}

	/**
	 * 转换
	 */
	private static void method2() {
		// 将字符串变成字符串数组
		// 其实就是字符串的切割
		// 这里面会涉及到正则表达式
		String s = "张三,李四,王五 ";
		String[] strings = s.split(",");
		for (String string : strings) {
			System.out.println(string);
		}
		// 将字符串变成字符数组
		char[] c = s.toCharArray();
		for (char d : c) {
			System.out.println(d);
		}
		// 将字符串变成字节数组
		byte[] b = s.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		// 将字符串转成大写或者小写
		String s1 = "absjedjhgkskdflkj";
		String s2 = s1.toUpperCase();
		System.out.println(s2);
		String s3 = s2.toLowerCase();
		System.out.println(s3);
		// 强字符串中的指定的内容进行替换
		// 如果没有找到替换的，则返回原来的字符串
		String s4 = s1.replace('s', '你');
		// 去除字符串前后两端的空格
		String s5 = " abc ".trim();
		System.out.println(s4);
	}

	/**
	 * 判断
	 */
	private static void method3() {
		String string = "Abc";
		// 忽略大小写比较字符串的大小
		string.equalsIgnoreCase("abc");
		// 字符串是否以指定字符串开头或者以指定字符串结束
		String string2 = "ArrarDemo.java";
		System.out.println(string2.startsWith("Array"));
	}

	/**
	 * 比较
	 */
	private static void method4() {
		// 比较两个字符串的大小
		// 小于返回负数 大于返回正数 等于返回零
		String string = "abc";
		int b = string.compareToIgnoreCase("cd");
		System.out.println(b);
	}
}
