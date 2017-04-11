package com.koumanwei.multi;

/**
 * 2017-04-11 下午12:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer(bank);
        Customer customer2 = new Customer(bank);
        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);
        thread1.start();
        thread2.start();
    }
}
// 有两个储户，同时到银行存钱，没人存三次，一次存100
// 要求只要银行每次金额的变化情况

// 首先保证是同一个银行，所以银行为共享数据。所以不能放到run方法中，因为每个线程都有自己的所属栈区
// 这是一个多线程程序，如何分析安全问题呢？
// 1、从线程任务代码中分析
// 2、是否有共享数据，有没有多条语句操作共享数据

class Customer implements Runnable {
    private Bank bank;

    public Customer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            bank.add(100);
        }
    }
}

// 没有加入同步时的一次打印结果：

// Thread-1银行金额：200
// Thread-0银行金额：200
// Thread-1银行金额：300
// Thread-1银行金额：500
// Thread-0银行金额：400
// Thread-0银行金额：600

class Bank {
    private int amout;
    private final Object o = new Object();

    void add(int num) {
        synchronized (o) {
            amout = amout + num;
            System.out.println(Thread.currentThread().getName() + "银行金额：" + amout);
        }
    }

    //
}