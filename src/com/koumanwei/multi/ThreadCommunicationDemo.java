package com.koumanwei.multi;

/**
 * 线程间通信
 * 2017-04-12 上午9:55
 *
 * @author koumanwei
 * @version 1.0
 */
public class ThreadCommunicationDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Input input = new Input(resource);
        Output output = new Output(resource);
        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);
        t1.start();
        t2.start();
    }
}

// 实现输入一个名字和性别，然后输出一个姓名和性别

// 等待唤醒机制：
// 涉及的方法：
// wait() 让线程处于冻结状态，被wait的线程会被存储到线程池中
// notify() 唤醒线程池中的任意一个线程
// notifyAll() 唤醒线程池中的所有线程

// 这些方法都必须定义在同步中，因为这些方法是用于操作线程状态的方法，必须要明确到底操作那个锁上的线程

class Input implements Runnable {
    private final Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (resource) {
                // 注意判断flag这里，不要用else，因为是代码执行到这里暂停
                if (resource.getFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    resource.setName("Kris");
                    resource.setsex("男");
                } else {
                    resource.setName("Zula");
                    resource.setsex("女");
                }
                resource.setFlag(true);
                resource.notify();
                x = (x + 1) % 2;
            }
        }
    }
}

class Output implements Runnable {
    private final Resource resource;

    public Output(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                if (!resource.getFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(resource.getName() + " " + resource.getsex());
                resource.setFlag(false);
                resource.notify();

            }
        }
    }
}

class Resource {
    private String name;
    private String sex;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    Resource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsex() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }
}