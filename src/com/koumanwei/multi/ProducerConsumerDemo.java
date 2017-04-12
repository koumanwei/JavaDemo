package com.koumanwei.multi;

/**
 * 生产者消费者问题
 * 2017-04-12 下午2:03
 *
 * @author koumanwei
 * @version 1.0
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer produce = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread t0 = new Thread(produce);
        Thread t1 = new Thread(produce);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(consumer);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
// 多生产者，多消费者问题
// 如果用if判断标记的话，会导致不该运行的线程运行了。出现了数据错误的情况
// while判断标记，解决了线程获取执行权后，是否要运行
// notify只能唤醒一个线程，如果本方唤醒本方，没有意义，而且while判断标记加上notify会导致死锁
// notifyAll解决了本方线程一定会唤醒对方的问题

/**
 * 仓库
 */
class Storage {
    private int count = 1;
    private String name;
    private boolean flag = false;

    /**
     * 增加产品
     */
    public synchronized void in(String name) {
        while (flag) {
            // 如果已经生产了，那么等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "...生产者.." + this.name);
        flag = true;
        notifyAll();

    }

    /**
     * 减少产品
     */
    public synchronized void out() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
        flag = false;
        notifyAll();

    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            storage.in("烤鸭");
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            storage.out();
        }
    }
}