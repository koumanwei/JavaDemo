package com.koumanwei.string;

public class StringTest1 {
	public static void main(String[] args) {
		// 1、给定一个字符串数组，按照字典顺序进行从小到大的排序
		// {"nba","abc","cba","zz","qq","hahaa"}
		// 思路：
		// 对数组进行排序，可以用选择，冒泡都行
		String[] arr = new String[] { "nba", "abc", "cba", "zz", "qq", "hahaa" };
		sortString(arr);
	}

	private static void sortString(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
