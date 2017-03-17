package com.koumanwei.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReflectDemo5 {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		// 笔记本电脑使用USB设备
		NoteBook book = new NoteBook();
		book.run();
		book.useUSB(null);

		File propertiesFile = new File("usb.properties");
		FileInputStream fileInputStream = new FileInputStream(propertiesFile);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		// 遍历获取USB设备
		for (int i = 1; i <= properties.size(); i++) {
			String className = properties.getProperty("usb" + i);
			System.out.println("className:" + className);
			Class clazz = Class.forName(className);
			Object newInstance = clazz.newInstance();
			USB usb = (USB) newInstance;
			book.useUSB(usb);
		}
		fileInputStream.close();
	}
}
