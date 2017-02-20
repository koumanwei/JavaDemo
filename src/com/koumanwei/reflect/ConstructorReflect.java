package com.koumanwei.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 构造方法的反射应用
 * 
 * @author koumanwei
 *
 */
public class ConstructorReflect {
	public static void main(String[] args) {
		// 获取指定的构造方法 需要制定类型
		try {
			// new String(new StringBuffer("abc));
			// 得到构造方法
			Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
			// 通过构造方法可以得到一些类的信息
			// 通过构造方法new对象
			try {
				// java.lang.IllegalArgumentException: argument type mismatch
				// 这里构造函数得到的StringBuffer类型的构造方法，而传入的是String类型的参数
				// 所以报错类型不匹配
				// String newInstance = constructor.newInstance("abc");
				// 创建对象
				String newInstance = constructor.newInstance(new StringBuffer("abc"));
				
				//-----------------------------------------------------------------------------------
				
				// 以上是利用获取构造方法的方式来创建对象
				String newInstance2 = String.class.newInstance();
				System.out.println(newInstance.charAt(2));
			} catch (InstantiationException e) {
				e.printStackTrace();
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
	}
}
