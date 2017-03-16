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
}
