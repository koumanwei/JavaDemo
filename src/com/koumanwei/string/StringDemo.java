package com.koumanwei.string;

public class StringDemo {
	public static void main(String[] args) {
		// String类型的特点
		// 字符串对象一旦被初始化就不会被改变
		String s = "abc";
		s = "nba";
		System.out.println(s);
		// 打印的结果是 nba
		// 看起来似乎跟前面的是矛盾的，其实不然
		// 因为n重新指向了另外一个字符串对象，abc本身没有改变

		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s == s1);
		// 打印结果 true
		// s和s1是两个对象，看起来应该是false
		// 在字符串建立时，有一个字符串常量池，首先去池子中寻找abc，没有找到
		// 那么把abc放入池子中，并把abc的地址个s1，然后s2去池子里面找abc，找到了，
		// 就把地址赋给s2

		// 注意：字符串是存储在字符串常量池中的
	}
}
