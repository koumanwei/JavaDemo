package com.koumanwei.multi;

/**
 * 2017-04-11 下午3:09
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadDemo4 {

    public static void main(String[] args) {
        MyTicket1 myTicket1 = new MyTicket1();
        // 创建两个线程
        Thread thread1 = new Thread(myTicket1);
        Thread thread2 = new Thread(myTicket1);
        thread1.start();
        try {
            thread1.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myTicket1.setFlag();
        thread2.start();
    }
}

// 静态函数使用的锁是什么呢？
// 因为静态中没有this，所以不是this
// 静态是随着类的加载而加载的，这是内存中存储的对象至少有一个，该类的字节码文件对象
// 这个对象的表示形式：类名.class，它就表示字节码文件对象
class MyTicket1 implements Runnable {
    private static int money = 100;
    private boolean flag = true;

    @Override
    public void run() {
        if (flag) {// 为true执行同步代码块
            while (true) {
                synchronized (MyTicket1.class) {
                    if (money > 0) {
                        try {
                            Thread.sleep(21);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "剩余" + money-- + "张票");
                    }
                }
            }
        } else {// 为false执行同步函数
            while (true) {
                show1();
            }
        }
    }

    public void setFlag() {
        flag = false;
    }

    public static synchronized void show1() {
        if (money > 0) {
            try {
                Thread.sleep(22);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "剩余" + money-- + "张票");
        }
    }
}
