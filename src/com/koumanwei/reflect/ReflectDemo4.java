package com.koumanwei.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		getMethodDemo();
		getMethodDemo2();
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

	/**
	 * 注意获取参数中是String数组的获取情况
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static void getMethodDemo2() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Class.forName("com.koumanwei.reflect.Person");
		Method method = clazz.getMethod("show", String[].class);
		// 这里必须包装
		method.invoke(clazz.newInstance(), new Object[] { new String[] { "nihao", "shijie" } });
		method.invoke(clazz.newInstance(), (Object) new String[] { "nihao", "shijie" });

		Method method1 = clazz.getMethod("show", int[].class);
		method1.invoke(clazz.newInstance(), new int[] { 5, 9, 12 });
	}
}
