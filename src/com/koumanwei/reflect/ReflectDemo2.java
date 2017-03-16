package com.koumanwei.reflect;

public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException {

	}

	/**
	 * 通过Class创建对象
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private static void createNewObj() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 1、查找并加载Person.class文件进内存，并将该文件封装成Class对象
		// 2、再依据Class对象创建该类具体的实例
		// 3、调用该类的构造函数对对象进行初始化

		// 这句代码执行了上面的三个步骤
		Person person = new Person();

		// 1、查找并加载指定类名的字节码文件进内存，并封装成Class对象
		Class clazz = Class.forName("com.koumanwei.reflect.Person");
		// 2、通过Class对象的newInstance创建该Class对象对应的类的实例
		// 这个方法会去使用该类的空参数构造函数进行初始化
		Object object = clazz.newInstance();
	}
}
