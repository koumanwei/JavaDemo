package com.koumanwei.multi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2017-04-12 下午5:38
 *
 * @author koumanwei
 * @version 1.0
 */
public class LockDemo2 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }

    // 对于同步代码块来说，对于锁的操作是隐式的
    // jdk1.5以后将同步和锁封装成了对象
    // 并将操作锁的隐式方式定义到了该对象中
    // 将隐式动作变成了显示动作

    // Lock接口：替代了同步代码块或者同步函数，将同步的隐式操作变成实现锁操作
    // 同时更为灵活，可以一个锁上加上多组监视器
    // lock()获取锁
    // unlock释放锁，通常定义在finally块中
    // Condition：替代了Object中wait notify notifyAll方法

    static class Resource {
        private String name;
        private int count = 1;
        private boolean flag = false;
        // 创建一个锁对象
        private final Lock lock = new ReentrantLock();
        // 通过已有的锁获取两组监视器，一组见识生产者，一组监视消费者
        Condition condition_pro = lock.newCondition();
        Condition condition_con = lock.newCondition();

        /**
         * 增加产品
         */
        public void in(String name) {
            lock.lock();
            try {
                while (flag) {
                    try {
                        condition_pro.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.name = name + count;
                System.out.println(Thread.currentThread().getName() + "....生产者5.0...." + this.name);
                count++;
                flag = true;
                condition_con.signal();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 消费产品
         */
        public void out() {
            lock.lock();
            try {
                while (!flag) {
                    try {
                        condition_con.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "....消费者5.0........" + this.name);
                flag = false;
                condition_pro.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable {
        private Resource resource;

        public Producer(Resource resource) {
            this.resource = resource;
        }


        @Override
        public void run() {
            while (true) {
                resource.in("烤鸭");
            }
        }
    }

    static class Consumer implements Runnable {
        private Resource resource;

        public Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                resource.out();
            }
        }
    }
}
