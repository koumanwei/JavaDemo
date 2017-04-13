package com.koumanwei.multi;

/**
 * 停止线程
 * 2017-04-13 下午1:14
 *
 * @author koumanwei
 * @version 1.0
 */
public class StopThreadDemo {
    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);
        t1.start();
        // 设置守护线程
        t2.setDaemon(true);
        t2.start();
        int num = 1;
        while (true) {
            if (++num == 50) {
                t1.interrupt();
//                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName() + "...run");
        }
        System.out.println("over");
    }
}
// 停止线程
// 1、stop方法
// 2、run方法结束
// 怎么控制线程的任务结束呢？
// 任务中都会有循环结构，只要控制住循环，就可以结束任务
// 控制循环，通常就用定义标记

// 如果线程处于冻结状态，那么久无法读取标记
// interrupt：清除冻结状态
// 将线程从冻结状态轻质恢复到运行状态，让线程具备cpu的执行资格
// 但是强制动作会发生中断异常，记得要处理

class StopThread implements Runnable {
    private boolean flag = true;

    public void setFlag() {
        flag = false;
    }

    @Override
    public synchronized void run() {
        while (flag) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + "...run");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + e);
            } finally {
                flag = false;
            }
        }
    }
}
