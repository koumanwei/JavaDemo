package com.koumanwei.control;

/**
 * 2017-04-01 23:32
 *
 * @author koumanwei
 * @version 1
 */
public class ForDemoTest2 {
    public static void main(String[] args) {
        // 打印:
        // * * * * * * * * *
        //  * * * * * * * *
        //   * * * * * * *
        //    * * * * * *
        //     * * * * *
        //      * * * *
        //       * * *
        //        * *
        //         *

        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            System.out.print(" ");
            for (int j = 9; j > i; j--) {
                if (j == i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print("* ");
                }

            }
            System.out.println();
        }
        // 分析；行是9行；列由9-1递减
        // 所以外层应该是循环9次
        // 因为列的个数在依次递减，而每次减少的个数正好等于行数
        // 所以列循环的次数等于9-行数，换句话说，列循环的次数应该是
        // 行数-9，根据这个条件就可以写出答案
        // 而星星的样式应该是一个星星加上一个空格
        // 并且，每一列的最后一个星星是没有空格的
        // 最后一个星星就是里层循环的最后一次
    }
}
