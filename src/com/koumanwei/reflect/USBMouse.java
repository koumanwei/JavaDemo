package com.koumanwei.reflect;

public class USBMouse implements USB {

	@Override
	public void open() {
		System.out.println("Mouse is open");
	}

	@Override
	public void close() {
		System.out.println("Mouse is close");
	}
}
