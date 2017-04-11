package com.koumanwei.multi;

/**
 * 2017-04-11 下午3:48
 *
 * @author koumanwei
 * @version 1.0
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock(true);
        Thread thread1 = new Thread(deadLock);
        Thread thread2 = new Thread(deadLock);
        thread1.start();
        try {
            thread1.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deadLock.setFlag();
        thread2.start();
    }
}
// 同步的另一个弊端：死锁
// 最常见的死锁情况：同步嵌套
// 同步中还有同步，两个同步不是同一个锁

class DeadLock implements Runnable {
    private int num = 100;
    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
        }
    }

    public void setFlag() {
        flag = false;
    }

    synchronized void show() {
        num--;
        System.out.println(num);
    }
}