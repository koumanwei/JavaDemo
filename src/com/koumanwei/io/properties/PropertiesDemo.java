package com.koumanwei.io.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		// Properties类是Map接口中HashMap的子类
		// 1、该类没有定义泛型，因为它的键值对都是固定的字符串类型
		// 2、因为存储的是字符串数据，通常作为属性信息存在
		// 3、该集合最大的特点就是可以和IO技术相结合，也就是
		// 该集合中的数据可以来自于流，也可以将集合中的数据写入到集合中
		// methoddemo_1();
		methoddemo_2();
	}

	/**
	 * 和流相接和的方法
	 * 
	 * @throws IOException
	 */
	private static void methoddemo_2() throws IOException {
		// 1、创建Properties集合对象
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/koumanwei/JavaTest/properties.txt");
		// 将流中的数据存储到集合中，使用集合的load方法
		prop.load(fis);
		// 想要对数据进行修改
		prop.setProperty("zhangsan", "20");
		prop.setProperty("lisi", "25");
		prop.setProperty("wangwu", "19");
		// 因为把流中的数据加载了，修改的只是集合中的数据，所以还要把数据存储到文件中
		FileOutputStream fos = new FileOutputStream("/Users/koumanwei/JavaTest/properties.txt");
		prop.store(fos, "First Writer");
		fos.close();
		fis.close();
		prop.list(System.out);
	}

	private static void methoddemo_1() {
		// 1、创建Properties集合对象
		Properties prop = new Properties();
		// 2、存储元素
		prop.setProperty("张三", "20");
		prop.setProperty("李四", "25");
		prop.setProperty("王五", "19");

		// 取元素，所有
		Set<String> stringPropertyNames = prop.stringPropertyNames();
		for (String name : stringPropertyNames) {
			String value = prop.getProperty(name);
			System.out.println("name:" + name + ",value:" + value);
		}
	}
}
