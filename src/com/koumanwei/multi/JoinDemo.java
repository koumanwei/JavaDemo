package com.koumanwei.multi;

/**
 * 2017-04-13 下午2:14
 *
 * @author koumanwei
 * @version 1.0
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread t1 = new Thread(join);
        Thread t2 = new Thread(join);
        t1.start();
        // t1线程要申请加入进来，运行
        // 此时，main线程释放执行权和执行资格，会等待t1执行结束然后接着运行
        // 临时加入一个线程运算可以使用join方法
        t1.join();
        t2.start();
        // 设置优先级，默认有三个，优先级越高，获取到cpu执行权的几率就越大
        t2.setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
            // 暂停线程
            Thread.yield();
        }
        // 面试题，下面会运行哪个方法?
        // 答案是运行B，因为B是子类，A是任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        }) {
            @Override
            public void run() {
                System.out.println("B");
            }
        }.start();
    }

    static class Join implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "...." + i);
            }
        }
    }
}
// 正常来说，是三个线程同时执行