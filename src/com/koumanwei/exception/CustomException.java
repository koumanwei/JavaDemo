package com.koumanwei.exception;

public class CustomException extends Exception{
	 public  CustomException(String msg) {
		 // 调用父类的构造方法
		 // 正常我们throw一个空指针异常的时候，在其构造函数中传入字符串就能有信息
		 // 其实内部就是调用了父类的构造方法
		 super(msg);
	}

	public void CustomException() {
	}
}
