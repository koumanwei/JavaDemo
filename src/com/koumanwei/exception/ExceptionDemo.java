package com.koumanwei.exception;

// 异常的应用
// 毕老师用电脑上课，上课的过程中电脑会蓝屏和冒烟，
// 蓝屏就重启就能继续上课，冒烟处理不了。因此公司会换个老师上课
// 请用面向对象的思想设计该程序
public class ExceptionDemo {
	public static void main(String[] args) {
		Teacher teacher = new Teacher("毕老师");
		try {
			teacher.teach();
		} catch (NoPlanException e) {
			System.out.println(e.toString());
			System.out.println("公司换人继续讲课");
		}
	}
}

// 1、首先，毕老师和电脑是对象，上课时毕老师的行为（功能），蓝屏和冒烟是电脑运行中出现的问题（异常）
class Teacher {
	private String name;
	private Computer computer;

	public Teacher(String name) {
		super();
		this.name = name;
		this.computer = new Computer();
	}

	// 老师讲课要用电脑，所以初始化的时候给老师一台电脑，
	// 老师在讲课的过程当中要让电脑运行起来
	public void teach() throws NoPlanException {
		try {
			computer.run();
			// 这句话应该放到try里面，应为一旦run方法出问题了老师就不能讲课了
			System.out.println(name + "讲课了");
		} catch (LanPingException e) {
			// 蓝屏的时候，应该重启电脑，该方法属于电脑
			System.out.println(e.toString());
			computer.reset();
			// 将电脑的状态恢复正常
			// 电脑恢复正常来时继续讲课
			teach();
		} catch (MaoYanException e) {
			System.out.println(e.toString());
			// 冒烟老师处理不了，但是不应该抛出去，这里要做异常的转换，
			// 老师的电脑冒烟，公司并不关心，公司也处理不了，应该让公司知道老师
			// 不能继续上课，这样公司就会换人，所以应该抛出一个新的异常
			System.out.println("让大家练习");
			throw new NoPlanException("老师不能继续讲课了");
		}
	}
}
// 2、老师应该有一个名字，后面的换人实际上也是属于老师这个类，只是名字不同。而电脑应该有个运行的方法
// 在运行的过程中可能出现蓝屏和冒烟

class Computer {
	// 默认电脑是正常运行的
	// 运行的过程中有三种状态，正常，冒烟，蓝屏
	private int state = 2;

	public void run() throws LanPingException, MaoYanException {
		// 蓝屏状态
		if (state == 1) {
			throw new LanPingException("电脑蓝屏了");
		}
		// 冒烟状态
		if (state == 2) {
			throw new MaoYanException("电脑冒烟了");
		}
		// 如果前面出异常了，那么将执行到这里，也就是说，如果没有异常，
		// 那么电脑能正常运行
		System.out.println("电脑运行");
	}

	public void reset() {
		// 恢复电脑的正常状态
		state = 0;
		System.out.println("电脑重启了");
	}
}

// 3、继承Exception而不是RuntimeException是因为这个异常可以做预处理
// 蓝屏了重启一下机器就可以了。所以应该继承Exception，进行捕捉处理
class LanPingException extends Exception {
	public LanPingException(String message) {
		super(message);
	}
}

class MaoYanException extends Exception {

	public MaoYanException(String message) {
		super(message);
	}
}

class NoPlanException extends Exception {

	public NoPlanException(String message) {
		super(message);
	}
}
