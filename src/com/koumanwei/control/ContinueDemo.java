package com.koumanwei.control;

/**
 * 2017-04-02 0:20
 *
 * @author koumanwei
 * @version 1
 */
public class ContinueDemo {
    public static void main(String[] args) {
        // continue
        // 作用的范围：循环结构
        for (int x = 0; x < 8; x++) {
            if (x % 2 == 0) {
                continue;
            }
            System.out.println(x);
        }
        // continue：结束本次循环，继续下一次循环
    }
}
