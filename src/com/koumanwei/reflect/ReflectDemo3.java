package com.koumanwei.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			InstantiationException, IllegalAccessException {
		getFieldDemo();
	}

	/**
	 * 获取字段
	 * 
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("com.koumanwei.reflect.Person");
		// 获取公共字段
		// Field field = clazz.getField("name");
		// 获取字段，包括私有
		Field field = clazz.getDeclaredField("age");
		// 利用对象获取字段的值，因为字段依附于某个对象，也就是说你要获取哪个对象的字段
		// 对私有字段的访问取消权限检查
		field.setAccessible(true);
		Object object = clazz.newInstance();
		// 给字段设置值 传入你要设置的对象和值
		field.set(object, 46);
		Object o = field.get(object);
		System.out.println(o);
	}
}
