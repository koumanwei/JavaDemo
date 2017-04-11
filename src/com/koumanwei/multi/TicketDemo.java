package com.koumanwei.multi;

/**
 * 2017-04-10 下午5:22
 *
 * @author koumanwei
 * @version 1.0
 */
public class TicketDemo {
    // 线程的6种状态

    // 1、NEW（新建）
    // 当用new操作符创建一个新线程时，如 new Thread(), 该线程还没有开始运行。

    // 2、RUNNABLE（可运行）
    // 可运行线程的线程状态。处于可运行状态的某一线程正在 Java 虚拟机中运行，但它可能正在等待操作系统中的其他资源，比如处理器。

    // 3、BLOCKED（被阻塞）
    // 受阻塞并且正在等待监视器锁的某一线程的线程状态。

    // 4、WAITING（等待）
    // 某一等待线程的线程状态。
    // 线程因为调用了Object.wait()或Thread.join()而未运行，就会进入WAITING状态

    // 5、TIMED_WAITING（等待）
    // 具有指定等待时间的某一等待线程的线程状态。
    // 线程因为调用了Thread.sleep()，或者加上超时值来调用Object.wait()或Thread.join()而未运行，则会进入TIMED_WAITING状态。

    // 6、TERMINATED
    // 已终止线程的线程状态。
    // 线程已运行完毕。它的run()方法已正常结束或通过抛出异常而结束
    public static void main(String[] args) {
        // 四个线程对象
//        Ticket t1 = new Ticket();
//        Ticket t2 = new Ticket();
//        Ticket t3 = new Ticket();
//        Ticket t4 = new Ticket();
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        // 这是一个任务的对象
        Ticket2 ticket2 = new Ticket2();
        // 四个线程对象
        Thread thread1 = new Thread(ticket2);
        Thread thread2 = new Thread(ticket2);
        Thread thread3 = new Thread(ticket2);
        Thread thread4 = new Thread(ticket2);
        // 让线程对象去运行指定的任务
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

// 买票的动作同时被四个窗口使用
// 那就是使用多线程技术
// 如果是继承Thread类，Thread的子类即封装了线程的任务，而且自身还是一个线程对象
// 这就是任务和对象耦合性过高
class Ticket extends Thread {
    private static int num = 100;

    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                // 将买票的代码定义在run方法中
                System.out.println(Thread.currentThread().getName() + "剩余" + num-- + "张票");
            }
        }
    }
}

// 如果实现Runnable接口，线程对象在使用该接口
// 我们只需要将其子类对象传递给线程对象就可以了
// 线程中任务是封装在run方法中的，而这个run方法被封装成了接口
// 所以其实现类是任务
// 此方法避免了单继承的局限性

// 多线程的安全问题？？
// 安全问题产生的原因：
// 1、多个线程在操作共享数据
// 2、操作共享数据的代码有多条，一个线程在执行多条操作共享数据的过程中，其他线程参与了运算。

// 想要分析多线程中是否有安全问题
// 依据：线程任务中有没有共享数据，该数据是否被多条语句操作

// 解决方案：只要保证一个线程在执行多条操作共享数据的语句时，其他线程不能参与运算。
// 当该线程都执行完以后，其他线程才可以执行这些语句

// 解决方法就是同步代码块：
// synchronized(任意的对象){}

// 同步的弊端：
// 会降低性能，这个是在可接受范围内的

// 一种现象：出现了多线程安全问题，为了解决，加上了同步，发现，问题依旧。
// 为什么呢？

// 同步的前提：
// 必须保证在同步中有多个线程，因为同步中只有一个线程是没有意义的
// 必须保证多个线程在同步中使用的是同一个锁

class Ticket2 implements Runnable {
    // 这个不需要采用static的来修饰
    private int num = 100;
    // 这个对象锁不能定义在run方法中，因为每个线程有自己所属的栈区，会导致不是同一把锁
    private final Object o = new Object();

    @Override
    public void run() {
        while (true) {
            // 这个同步对象其实就是锁
            // 谁持有这个对象（锁），谁就能执行，执行完释放该对象
            if (num > 0) {
                synchronized (o) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 将买票的代码定义在run方法中
                    System.out.println(Thread.currentThread().getName() + "剩余" + num-- + "张票");
                }
            }
        }
    }
}