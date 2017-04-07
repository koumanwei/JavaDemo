package com.koumanwei.oo.inter;

/**
 * 2017-04-08 1:27
 *
 * @author koumanwei
 * @version 1.0
 */
public class InterDemo4 {
    public static void main(String[] args) {
        BookPC bookPC = new BookPC();
        // 这些设备和电脑的耦合性降低了
        bookPC.useUSB(new Mouse());
        bookPC.useUSB(new Key());
        bookPC.useUSB(new Upan());
    }
}

// 笔记本的使用
// 为了扩展笔记本的功能，但日后出现什么功能设备不知道
// 定义一个规则，只要日后出现的设备都符合这个规则就可以了
interface USB {
    public abstract void open();

    public abstract void close();
}

class BookPC {
    // 接口类型的引用，指向的都是子类对象
    public void useUSB(USB usb) {
        usb.open();
        usb.close();
    }
}

class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("鼠标开始运行了");
    }

    @Override
    public void close() {
        System.out.println("鼠标结束运行了");
    }
}

class Key implements USB {
    @Override
    public void open() {
        System.out.println("键盘开始运行了");
    }

    @Override
    public void close() {
        System.out.println("键盘结束运行了");
    }
}

class Upan implements USB {
    @Override
    public void open() {
        System.out.println("u盘结束运行了");
    }

    @Override
    public void close() {
        System.out.println("u盘结束运行了");
    }
}