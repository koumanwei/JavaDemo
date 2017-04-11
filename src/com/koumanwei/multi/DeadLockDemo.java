package com.koumanwei.multi;

/**
 * 2017-04-11 下午3:48
 *
 * @author koumanwei
 * @version 1.0
 */
public class DeadLockDemo {
    public static final Object LOCKA = new Object();
    public static final Object LOCKB = new Object();

    public static void main(String[] args) {
        Lock1 lock1 = new Lock1();
        Lock2 lock2 = new Lock2();
        Thread thread1 = new Thread(lock1);
        Thread thread2 = new Thread(lock2);
        thread1.start();
        thread2.start();
    }
}
// 同步的另一个弊端：死锁
// 最常见的死锁情况：同步嵌套
// 同步中还有同步，两个同步不是同一个锁


// 下面的例子说明：

// 首先封装了两个线程任务lock1和lock2
// 然后开启了两个线程分别取执行这两个任务
// 假设lock1任务先执行了，并且拿到A锁，并打印了Lock1 A
// 这个时候lock2也执行了，并且拿到B锁，并打印了Lock2 B
// 此时都需要对方释放锁才能继续执行，所以变成了死锁
class Lock1 implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (DeadLockDemo.LOCKA) {
                System.out.println(Thread.currentThread().getName() + " Lock1 A");
                synchronized (DeadLockDemo.LOCKB) {
                    System.out.println(Thread.currentThread().getName() + " Lock1 B");
                }
            }
        }
    }
}

class Lock2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (DeadLockDemo.LOCKB) {
                System.out.println(Thread.currentThread().getName() + " Lock2 B");
                synchronized (DeadLockDemo.LOCKA) {
                    System.out.println(Thread.currentThread().getName() + " Lock2 A");
                }
            }
        }
    }
}