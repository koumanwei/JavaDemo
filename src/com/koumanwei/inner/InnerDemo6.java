package com.koumanwei.inner;

/**
 * 2017-04-08 20:15
 *
 * @author koumanwei
 * @version 1.0
 */
public class InnerDemo6 {
    public static void main(String[] args) {
        OuterE outerE = new OuterE();
        outerE.method();
    }
}

// 匿名内部类的使用场景之一
// 当函数参数是接口类型时，而且接口中的方法不超过3个时，可以用匿名内部类
// 作为实际参数进行传递

interface Inter {
    public abstract void show1();

    public abstract void show2();
}

class OuterE {
//    class Inner implements Inter {
//        @Override
//        public void show1() {
//            System.out.println("show1");
//            System.out.println("show2");
//        }
//
//        @Override
//        public void show2() {
//
//        }
//    }

    public void method() {
//        Inner inner = new Inner();
//        inner.show2();
//        inner.show2();
        new Inter() {
            @Override
            public void show1() {

            }

            @Override
            public void show2() {

            }
        }.show1();
//        Inter inter = new Inter() {
//            @Override
//            public void show1() {
//
//            }
//
//            @Override
//            public void show2() {
//
//            }
//
//            private void show3() {
//                System.out.println("这个是子类特有的方法");
//            }
//        };
//        inter.show3();

        // 如果用变量去接收这个类的话，那么子类特有的方法就无法访问了，因为发生了向上转型
        new Inter() {
            @Override
            public void show1() {

            }

            @Override
            public void show2() {

            }

            private void show3() {
                System.out.println("这个是子类特有的方法");
            }
        }.show3();
    }
}