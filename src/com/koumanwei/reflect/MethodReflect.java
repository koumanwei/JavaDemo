package com.koumanwei.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 成员方法的反射
 * 
 * @author koumanwei
 *
 */
public class MethodReflect {
	public static void main(String[] args) {
		try {
			String string = "abc";
			// 获取某个类上的方法，参数一，是方法的名字，但是因为方法有重载
			// 所以第二个参数，代表该方法中的参数类型
			Method method = String.class.getMethod("charAt", int.class);
			try {
				// 某个具体的对象调用该方法，第二个参数是传入的实际参数
				char value = (char) method.invoke(string, 1);
				// 如果invoke中的第一个参数为null，说明这个方法是静态方法，
				// 因为静态方法不依赖对象调用
				System.out.println(value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		/**
		 * 动态去调用某个类的main方法
		 */
		// 启动java程序的main方法的参数是一个字符串数组，即是public static void main(String[] args),
		// 通过反射的方式来调用这个main方法时，如何为invoke方法传递参数呢？按jdk1.5的语法，整个数组是一个参数
		// 而按照jdk1.4的语法
		String startingClassName = args[0];
		try {
			Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
			try {
				// 因为这里会把数组当成是一个数组传递了三个参数，所以再包装一次
				mainMethod.invoke(null, new Object[] { new String[] { "123", "222", "333" } });
				// 这里是强制转为为一个对象，让编译器知道这是一个对象
				// mainMethod.invoke(null, (Object) new String[] { "123", "222",
				// "333" });
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

/**
 * 对接收数组参数的成员方法进行反射
 * 
 * @author koumanwei
 *
 */
class TestArguments {
	// 鼠标放在MainMethod那地方，按下F2，copy
	// com.koumanwei.reflect.TestArguments，放在Run Configutationsde
	// arguments里面。apply，Run TestMainMethod就好了。
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println("内容：" + arg);
		}
	}
}
