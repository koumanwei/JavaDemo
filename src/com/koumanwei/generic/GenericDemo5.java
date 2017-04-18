package com.koumanwei.generic;

/**
 * 2017-04-18 20:42
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericDemo5 {
    public static void main(String[] args) {
        InterImpl inter = new InterImpl();
        inter.show("nihao");
        InterImpl2 inter2 = new InterImpl2();
        inter.show("wo");
    }
}

// 泛型接口
interface Inter<T> {
    void show(T t);
}

class InterImpl implements Inter<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

class InterImpl2<R> implements Inter<R> {

    @Override
    public void show(R r) {
        System.out.println(r);
    }
}