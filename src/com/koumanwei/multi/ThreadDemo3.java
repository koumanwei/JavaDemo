package com.koumanwei.multi;

/**
 * 2017-04-11 0:05
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        // 线程对外提供了接口，那么它就会使用这个接口
        Demo demo = new Demo();
        Thread thread = new Thread(demo);
        thread.start();
        Thread thread1 = new Thread(demo);
        thread1.start();
    }
}

// 常见线程的第二种方式：实现Runnable接口
// 1、覆盖接口中的run方法，将线程的任务代码封装到run方法中
// 2、通过Thread类创建线程对象，并将Runnable接口的子类对象
// 作为Thread类的构造函数的参数进行传递
// 为什么呢？
// 因为线程的任务都封装在Runnable接口子类对象的run方法中
// 所以要在线程对象创建时就必须明确要运行的任务
// 3、调用线程对象的start方法开启线程

class Demo implements Runnable {
    @Override
    public void run() {
        show();
    }

    public void show() {
        for (int i = 0; i < 9; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "," + Thread.currentThread().getId());
        }
    }
}