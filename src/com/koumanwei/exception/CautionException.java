package com.koumanwei.exception;

public class CautionException {
	public static void main(String[] args) {
		Test test = new Test();
		test.method(new Fu());
		test.method(new Zi());
	}
}

// 异常的注意事项:
// 1、子类在覆盖父类的方法时，父类的方法如果抛出了异常
// 那么子类的方法只能抛出父类的异常，或者该异常的子类

// 2、如果父类抛出多个异常，那么子类只能抛出父类异常的子集

// 注意：如果父类的方法没有抛出异常，子类覆盖时绝对不能抛，只能try
class A extends Exception {
}

class B extends A {
}

class C extends Exception {
}

class Fu {
	public void show() throws A {
	}
}

class Zi extends Fu {
	@Override
	public void show() throws B {
	}
}

class Test {
	public void method(Fu fu) {
		try {
			fu.show();
		} catch (A e) {
			// 在这里处理了父类的异常,如果Zi类中抛出了C异常
			// 那么这里就不能处理，当调用的时候，把子类传进来
			// 子类中有新的异常，就会导致程序崩溃
			// 所以验证上面所说的第一点
		}
	}
}