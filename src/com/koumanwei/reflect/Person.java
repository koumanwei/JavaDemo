package com.koumanwei.reflect;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	private void show() {
		System.err.println("我是Person中的私有方法");
	}

	public void show(String[] arry) {
		for (String string : arry) {
			System.out.println(string);
		}
	}

	public void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
