package com.koumanwei.multi;

/**
 * 2017-04-10 下午5:22
 *
 * @author koumanwei
 * @version 1.0
 */
public class TicketDemo {
    public static void main(String[] args) {
    }
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
}
