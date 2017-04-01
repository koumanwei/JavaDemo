package com.koumanwei.control;

/**
 * 2017-04-01 下午2:53
 *
 * @author koumanwei
 * @version 1
 */
public class ForDemoTest {
    public static void main(String[] args) {
        // 打印出：
        // **********
        // *********
        // ********
        // *******
        // ******
        // *****
        // ****
        // ***
        // **
        // *
        // 对于图形而言，嵌套for，外层控制行数，内层控制列数

        // 分析：一个有多个，并且有多行。所以用嵌套for

        /*for (int x = 10; x > 0; x--) {
            for (int y = x; y > 0; y--) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 其实，外层和内层控制的都是循环的次数，所以可以是任意的数据的范围
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
        show3();
    }

    public static void show() {
        // 打印：
        // *
        // **
        // ***
        // ****
        // *****
        // ******
        // *******
        // ********
        // *********
        // **********

        // 控制行
        for (int i = 0; i < 10; i++) {
            // 控制列
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void show2() {
        // 打印：
        // 987654321
        // 98765432
        // 9876543
        // 987654
        // 98765
        // 9876
        // 987
        // 98
        // 9
        // 控制行
        for (int i = 0; i < 9; i++) {
            // 控制列 列从高到低一次递减，从这里就可以写出里层for
            for (int j = 9; j > i; j--) {
                System.out.print(String.valueOf(j));
            }
            System.out.println();
        }
    }

    public static void show3() {
        // 打印：九九乘法表
        // 1*1=1
        // 1*2=2 2*2=4
        // 1*3=3 2*3=6 3*3=9
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                int length = String.valueOf(j * i).length();
//                if (length == 1) {
//                    System.out.print(j + "*" + i + "=" + j * i + "  ");
//                } else {
//                    System.out.print(j + "*" + i + "=" + j * i + " ");
//                }
                System.out.print(j + "*" + i + "=" + j * i + "\t");

            }
            System.out.println();
        }
    }
}
