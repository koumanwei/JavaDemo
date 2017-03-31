package com.koumanwei.control;

/**
 * Created by koumanwei on 2017-03-31.
 */
public class IfDemo {
    public static void main(String[] args) {
        /**
         *   if的第一种格式：if(){}
         */
        // 当语句中只有一条语句时，可以省略大括号不写
        // 换句话说，如果if没有写{}，那么if就只能控制
        // 距离它最近的那条语句
        // if(表达式){执行语句}
        int x = 0;
        if (x < 1) {
            // 这里的if语句就只是一条语句，所以可以省略
            // 注意：单条不是单行
            if (x < 2) {
                System.out.println("nihao");
            }
        }
        // 注意上面的可以简写成
        if (x < 1)
            if (x < 2)
                System.out.println("nihao");

        /**
         *   if的第二种格式：if(){}else{}
         */
        // 三元运算符就是if else的简写
        // 简写格式什么时候用：
        // 当ifelse运算后，有一个具体的结果时，可以简化成三元元算
        // 因为三元运算是运算符，必须有一个结果
    }
}
