package com.koumanwei.keyword;

public class FinalDemo {
	public static void main(String[] args) {
		// final可以修饰类，方法，变量
		// 1、修饰的类不可以被继承
		// 2、修饰的方法不可以被覆盖
		// 3、修饰的变量是一个常亮，只能被赋值一次（常量的名字必须每个字母都大写，用下划线分隔）
		// 4、内部类只能访问被修饰的局部变量

		// 如果程序中一个值是固定的，那么直接使用这个数据就可以了，但是阅读性差
		// 所以应该给这个数据起一个名称，而且这个变量的值不能改变，所以用final修饰
		// 如果这个常量只想在本类中使用，就不需要家额外的修饰符
		// 如果一个值固定，那么这个数据就不是特有数据，一般会被共享，所以
		// final一般会跟着static出现，如果只想在本类中使用，那么就加上private
		// 如果想对外提供，就就加上public

	}
}

// 继承有一个弊端，打破了封装性
// 使用final修饰以后就不能继承了
final class Fu {

	void method() {
		final int x = 9;
	}
}

class Fu2 {
	// 这个方法调用了底层资源，不想让别人修改
	// final修饰的方法不可以被覆盖
	final void method() {
		// 调用了底层系统的资源
	}
}
