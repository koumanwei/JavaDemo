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
public class LockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(consumer);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }

    // 对于同步代码块来说，对于锁的操作是隐式的
    // jdk1.5以后将同步和锁封装成了对象
    // 并将操作锁的隐式方式定义到了该对象中
    // 将隐式动作变成了显示动作
    static class Resource {
        private String name;
        private int count = 1;
        private boolean flag = false;
        // 创建一个锁对象
        private final Lock lock = new ReentrantLock();
        // 通过已经有的锁对象获取该锁上的监视器对象
        Condition condition = lock.newCondition();

        /**
         * 增加产品
         */
        public void in(String name) {
            lock.lock();
            try {
                while (flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.name = name + count;
                System.out.println(Thread.currentThread().getName() + "....生产者5.0...." + this.name);
                count++;
                flag = true;
                condition.signalAll();
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
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "....消费者5.0........" + this.name);
                flag = false;
                condition.signalAll();
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
