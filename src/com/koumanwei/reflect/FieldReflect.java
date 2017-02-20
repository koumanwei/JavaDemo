package com.koumanwei.reflect;

import java.lang.reflect.Field;

public class FieldReflect {
	public static void main(String[] args) {
		ReflectPoint point = new ReflectPoint(3, 5);
		try {
			// 不代表具体的值
			Field fieldY = point.getClass().getField("y");
			Field[] fields = point.getClass().getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			try {
				// 获取某个某个对象上改成员变量具体的值
				System.out.println(fieldY.get(point));
				Field fieldX = point.getClass().getDeclaredField("x");
				fieldX.setAccessible(true);
				System.out.println(fieldX.get(point));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		changeStringValue(point);
		System.out.println(point.toString());
	}

	/**
	 * 获取类中的成员变量，并把String类型的成员变量改变
	 * 
	 * @param object
	 */
	private static void changeStringValue(Object object) {
		Field[] fields = object.getClass().getFields();
		for (Field field : fields) {
			// 获取成员变量的类型
			Class<?> type = field.getType();
			// 判断是否是String类型
			// 因为字节码只有一份，所以用==而不用equals
			if (type == String.class) {
				try {
					// 取到该成员变量在某个具体对象上的值
					String oldValue = (String) field.get(object);
					String newValue = oldValue.replace('b', 'a');
					// 设置该成员变量在某个具体对象上的值
					field.set(object, newValue);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
