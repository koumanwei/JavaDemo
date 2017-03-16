package com.koumanwei.io.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		// 定义一个功能，用于记录软件运行的次数，如果次数大于5次，不要在运行
		// 并给出提示：试用次数已到，请注册
		getCount();
	}

	private static void getCount() throws IOException {
		Properties properties = new Properties();
		int count = 0;
		// 配置文件
		File config = new File("/Users/koumanwei/Desktop/config.txt");
		if (!config.exists()) {
			config.createNewFile();
		}
		FileInputStream fis = new FileInputStream(config);
		// 将流关联的数据加载到Properties中
		properties.load(fis);
		// 获取配置文件中的次数
		String value = properties.getProperty("count");
		if (value != null) {
			count = Integer.parseInt(value);
			if (count > 4) {
				System.out.println("试用次数已到，请注册");
				return;
			}
		}
		count++;
		System.out.println("运行了" + count + "次");
		// 存储到集合中
		properties.setProperty("count", String.valueOf(count));
		// 将集合中的数据写入到文件中以便持久化配置
		// 注意这个输出流不要往上面写，因为输出流会覆盖文件
		FileOutputStream fos = new FileOutputStream(config);
		properties.store(fos, "");
		fis.close();
		fos.close();
	}
}
