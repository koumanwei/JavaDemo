package com.koumanwei.control;

/**
 * 2017-04-01 下午5:58
 *
 * @author koumanwei
 * @version 1
 */
public class BreakDemo {
    public static void main(String[] args) {
        // break 跳出应用范围
        // 1、switch语句
        // 2、循环

        /*for (int x = 0; x < 3; x++) {
            // break语句单独存在的时候，下面不要定义任何语句，因为执行不到
            if (x == 2) {
                break;
            }
            System.out.println(x);
        }*/

        // 这里直接跳出了for循环

        for (int x = 0; x < 9; x++) {
            if (x == 5) {
                break;
            }
            // break语句单独存在的时候，下面不要定义任何语句，因为执行不到
            for (int j = 0; j < 9; j++) {
                System.out.println("inner");
                break;
            }
            System.out.println("out---------" + x);
        }
        // 默认break跳出当前循环，正常是9个inner对应一个out
        // 但是因为里层break了，只能外层执行了一次，里层也只能执行一次
    }
}
