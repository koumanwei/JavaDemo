package com.koumanwei.exception;

//异常处理的捕捉形式
//这是针对异常进行针对性处理的方式
//具体的格式是：
/*
try{
		// 需要被检测的异常代码
	}catch(异常类 变量){ // 该变量用于接收发生的异常对象
		// 处理异常的代码
	}finally{
		// 一定会被执行的代码
	}
*/
public class CatchException {
	public static void main(String[] args) {
		Demo demo = new Demo();
		int[] arr = new int[3];
		try {
			int num = demo.method(arr, -30);
			System.out.println("num=" + num);
		} catch (CustomException e) {
			// jvm默认的处理方式就是调用异常对象的此方法
			e.printStackTrace();
			// 控制台打印e，相当于调用了e.toString()，因为控制台无论你打印什么
			// 最后都会变成字符串
			System.out.println(e);
			System.out.println("负数角标异常");
		}
		System.out.println("over");
	}
	// 程序可以输出over，因为已经处理了异常，所以代码继续往下执行，但是不能输出num了
}

class Demo {
	public int method(int[] arr, int index) throws CustomException {
		if (index < 0) {
			throw new CustomException("变成负数啦");
		}
		return arr[index];
	}
}
/*
 * 1、函数内部如果抛出了需要检测的异常，那么函数上必须声明 否则必须在函数内使用trycatch捕捉，否则编译失败。
 * 2、如果调用了声明异常的函数，要么trycatch要么throws，否则编译失败。 3、什么时候catch，什么时候throws呢？
 * 功能可以解决，用catch，解决不了，用throws告诉调用者，由调用者处理。
 * 4、一个功能如果抛出了多个异常，那么调用时，必须由对应多个catch进行针对性处理，内部有几个需要检测的异常，就抛出 几个，就catch几个。
 * 5、过个catch的时候，父类异常应该放在后面。
 */
