package com.koumanwei.multi;

/**
 * 2017-04-11 下午1:32
 *
 * @author koumanwei
 * @version 1.0
 */
public class BankDemo2 {
    public static void main(String[] args) {
        Bank1 bank1 = new Bank1();
        Customer1 customer3 = new Customer1(bank1);
        Customer1 customer4 = new Customer1(bank1);
        Thread thread1 = new Thread(customer3);
        Thread thread2 = new Thread(customer4);
        thread1.start();
        thread2.start();
    }
}

class Customer1 implements Runnable {
    private Bank1 bank1;

    public Customer1(Bank1 bank1) {
        this.bank1 = bank1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank1.add(100);
        }
    }
}

class Bank1 {
    private int amout;
    private final Object o = new Object();

    // 发现同步代码块和函数，封装的内容是一样的，直接用函数封装不就可以了吗
    // 只要让函数具备同步性就可以了
    // 直接将同步关键字所谓函数的修饰符即可

//    void add(int num) {
//        synchronized (o) {
//            amout = amout + num;
//            System.out.println(Thread.currentThread().getName() + "银行金额：" + amout);
//        }
//    }

    // 这就是同步函数，同步的另外一种表现形式
    // 这种表现形式较为简单
    synchronized void add(int num) {
        amout = amout + num;
        System.out.println(Thread.currentThread().getName() + "银行金额：" + amout);
    }
}