package com.koumanwei.exception;

public class Main {
	public static void main(String[] args) throws CustomException {
		run(4);
}
	private static void run(int index) throws CustomException{
		if (index<0) {
			throw new CustomException("传入的参数不能够为负数");
			// 这里必须捕获或者抛出，因为是受检测异常，继承了Exception
		}
		if (index<5) {
			throw new NullPointerException();
			// 这个是RuntimeException，所以不是受检测异常
		}
	}
}

// 注意：throws使用在函数上，是用来把问题暴露给调用者，throw是用来抛出异常对象的
// 如果函数内发生了异常，必须在函数上声明。因为函数是封装的，是一个功能模块，应该
// 把问题暴露给外界。而不应该自己去捕获

// 异常的分类：
// 1、编译时被检测异常：除了RuntimeException体系，Exception和其子类都是
// 这种问题一旦出现，希望在编译时就进行检测，让这种问题有对应的处理方式
// 这样的问题可以针对性处理
// 2、编译时不检测异常：RuntimeException和其子类
// 这种问题的发生，无法让功能继续，运算无法进行，更多是因为调用者的原因导致或者引发内部
// 状态的改变，这种问题一般不处理，直接编译通过，在运行时，让调用者调用时的程序强制
// 停止，让调用者对代码进行修正

// RuntimeException是：是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类
// 可能在执行方法期间抛出但未被捕获的 RuntimeException 的任何子类都无需在 throws 子句中进行声明。
// 而Error会导致Java虚拟机不正常运行

// 自定义异常时：要么继承Exception，要么继承RuntimeException

// throw和throws的区别：
// throw使用在函数内。throws抛出的是异常类，可以抛出多个，用逗号分隔，
// throw抛出的是异常对象