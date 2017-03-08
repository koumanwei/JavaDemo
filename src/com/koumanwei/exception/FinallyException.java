package com.koumanwei.exception;

public class FinallyException {
	public static void main(String[] args) {
		FinallyDemo demo = new FinallyDemo();
		try {
			demo.show(-3);
		} catch (CustomException e) {
			e.printStackTrace();
			return;
		} finally { // 通常用于关闭（释放）资源
			System.out.println("finally");
		}
		System.out.println("over");
	}
	// 输出finally和over
	// 因为finally块最终都会被执行，即使函数已经返回；
	// 而over作为函数中的代码，方发生异常的时候，因为在catch中结束了该函数，
	// 所以出现异常的时候不会输出over
	// 当调用了System.exit(0)结束虚拟机的时候，finally不会执行到
	// 因为虚拟机都挂了
}

class FinallyDemo {
	public int show(int index) throws CustomException {
		if (index < 0) {
			throw new CustomException("越界了");
		}
		int[] arr = new int[3];
		return arr[index];
	}
}
// try catch finally 代码块组合特点
// 1、try catch finally
// 2、try catch(多个) 当没有必要的资源释放时，可以不用定义finally
// 3、try finally 此时没有处理异常，所以必须在函数上用throws声明
// 没有catch就没有处理，异常无法直接处理，但是资源需要关闭的时候，就这try finally的情况