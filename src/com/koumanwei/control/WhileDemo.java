package com.koumanwei.control;

/**
 * 2017-04-01 下午1:20
 *
 * @author koumanwei
 * @version 1
 */
public class WhileDemo {
    public static void main(String[] args) {
        computeSum();
        getSix();
    }

    public static void computeSum() {
        // 1、按照顺序，先算出两个数的和，再用这个和与下一个数相加
        // 2、以此类推，这个和就算出来
        // 步骤：
        // 1、先将1-10这10个数弄出来，定义一个变量，让这个变量自增，而且是在循环中自增
        // 2、每一个都是前两个数的和加上下一个数
        // 前两个数的和也不确定，在定义一个变量，记录每次的和
        // 而且两个数的和加上下一个数的动作也会被执行多次，也定义在循环中
        // 3、最后打印
        int x = 1;
        int sum = 0;
        while (x <= 100) {
            sum += x;
            x++;
        }
        System.out.println(sum);
    }

    /**
     * 获取1-100之间能被6整除的个数
     */
    public static void getSix() {
        // 个数不确定，定义成变量count
        // 1-100之间的数不确定，定义成一个变量x
        int count = 0;
        int x = 1;
        while (x <= 100) {
            if (x % 6 == 0) {
                count++;
                System.out.print(x + ",");
            }
            x++;
        }
        System.out.println("0-100是6的倍数的个数为：" + count);
    }
}
