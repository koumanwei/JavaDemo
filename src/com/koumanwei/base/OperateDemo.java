package com.koumanwei.base;

/**
 * 2017-03-31 下午12:35
 *
 * @author koumanwei
 * @version 1
 */
public class OperateDemo {
    public static void main(String[] args) {
        int a = 5;
        // 相当于a = a+1;
        // System.out.println(a);
        // int c = a++;
        // 因为a在前，++在后，说明a的数值需要参与++以外的运算，不如赋值个b的运算；
        // 所以，运算过程是这样的
        // 1、先把a变量中的数据，进行临时存储
        // temp = a;
        // 2、自增运算，a = a + 1;
        // 此时a=5;
        // 3、将临时存储a数据的变量赋值给b
        // b = temp;
        // 此时b=5;

        int b = ++a;
        System.out.println(b);
    }
}
