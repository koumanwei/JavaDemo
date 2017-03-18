package com.koumanwei.string;

public class StringTest2 {
	public static void main(String[] args) {
		// 一个字符串在整字符串中出现的次数
		String s1 = "nbadsfnbasdnbasdfnbalnba";
		String key = "nba";
		// 思路：
		// 1、要找的子串是否存在，如果存在获取其存在的位置
		// 2、如果找到了，那么就在剩余的字符串中查找

		getCount(s1, key);
		getCount2(s1, key);
	}

	/**
	 * 这个方法会让池子中多很多字符串
	 * 
	 * @param s
	 * @param key
	 */
	private static void getCount(String s, String key) {
		// 1、定义计数器
		int count = 0;
		// 2、定义变量记录key出现的位置
		int index = 0;
		while ((index = s.indexOf(key)) != -1) {
			// 剩余的子字符串
			s = s.substring(index + key.length());
			count++;
		}
		System.out.println(count);
	}

	/**
	 * 此方法不会生成多余的字符串
	 * 
	 * @param s
	 * @param key
	 */
	private static void getCount2(String s, String key) {
		// 1、定义计数器
		int count = 0;
		// 2、定义变量记录key出现的位置
		int index = 0;
		while ((index = s.indexOf(key, index)) != -1) {
			index = index + key.length();
			count++;
		}
		System.out.println(count);
	}
}
