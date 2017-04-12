package com.koumanwei.multi;

/**
 * 2017-04-12 下午12:00
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadCommunicationDemo2 {
    public static void main(String[] args) {
        Share share = new Share();
        Set set = new Set(share);
        Get get = new Get(share);
        Thread t1 = new Thread(set);
        Thread t2 = new Thread(get);
        t1.start();
        t2.start();
    }
}

class Share {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        notify();
    }

    public synchronized void get() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "" + sex);
        flag = false;
        notify();
    }
}

class Set implements Runnable {
    private Share share;

    public Set(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            if (x == 0) {
                share.set("Kris", "男");
            } else {
                share.set("Zula", "女");
            }
            x = (x + 1) % 2;
        }
    }
}

class Get implements Runnable {
    private Share share;

    public Get(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        while (true) {
            share.get();
        }
    }
}