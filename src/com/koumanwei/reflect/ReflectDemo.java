package com.koumanwei.reflect;

public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		// 如何获取Class对象呢？
		// 方式一：
		// 通过对象的getClass方法进行获取
		getObject_3();
	}

	/**
	 * 方式一
	 * 
	 * 麻烦在于每次都需要具体的类和该类的对象以及调用getClass方法
	 */
	public static void getObject_1() {
		Person person = new Person();
		Class clazz = person.getClass();

		Person person1 = new Person();
		Class clazz1 = person1.getClass();
		// flase
		System.out.println(person == person1);
		// true 字节码只有一份
		System.out.println(clazz == clazz1);
	}

	/**
	 * 方式二
	 * 
	 * 任何数据类型都具备一个静态的属性class，这个属性可以直接获取该类型的对应Class对象
	 * 
	 * 比第一种简单，不用创建对象，不用调用getClass方法，但是还是要使用具体的类，和该类中的一个静态属性class
	 */
	public static void getObject_2() {
		Class clazz = Person.class;
	}

	/**
	 * 方式三
	 * 
	 * 这种方式较为简单，只要知道类的名称即可，不需要该类，也不需要去调用具体的属性和行为
	 * 
	 * 这种仅知道类名就可以知道该类字节码对象的方式更有利于扩展，因为类名可以作为变量传入
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void getObject_3() throws ClassNotFoundException {
		// 必须写类的全名
		Class clazz = Class.forName("com.koumanwei.reflect.Person");
		System.out.println(clazz);
	}
}
