package com.koumanwei.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		getMethodDemo();
	}

	/**
	 * 获取方法
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	private static void getMethodDemo() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.koumanwei.reflect.Person");
		// 获取方法 要指定方法名字和参数列表
		Method declaredMethod = clazz.getDeclaredMethod("show", null);
		Object newInstance = clazz.newInstance();
		//// 对私有方法的访问取消权限检查
		declaredMethod.setAccessible(true);
		// 运行方法需要对象和实际参数
		declaredMethod.invoke(newInstance, null);
	}
}
