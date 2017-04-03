package com.koumanwei.base;

/**
 * 2017-04-02 22:18
 *
 * @author koumanwei
 * @version 1
 */
public class MethodDemo {
    // 根据考试成绩获取学生对应的等级
    // 90-100 A
    // 80-89 B
    // 70-79 C
    // 60-69 D
    // 60一下 E
    public static void main(String[] args) {
        getLevel(78);
    }

    private static char getLevel(int num) {
        char level = 0;
        if (num >= 90 && num <= 100) {
            level = 'A';
        } else if (num >= 80 && num <= 89) {
            level = 'B';
        } else if (num >= 70 && num <= 79) {
            level = 'C';
        } else if (num >= 60 && num <= 69) {
            level = 'D';
        } else if (num < 60) {
            level = 'E';
        }
        return level;
        // 注意：因为返回的结果是不确定的，所以可以用一个变量来记录这个返回的结果
        // 当定义level的时候，必须给它一个初始值，因为if和else if有可能执行不到
        // 那么level就没有值，但是如果最后一个else if换成else就可以，因为if和else总有一个会被
        // 执行到，也就是说level一定会有值。

        // 局部变量在使用之前必须初始化
    }

    private static char getLevel1(int num) {
        if (num >= 90 && num <= 100) {
            return 'A';
        } else if (num >= 80 && num <= 89) {
            return 'B';
        } else if (num >= 70 && num <= 79) {
            return 'C';
        } else if (num >= 60 && num <= 69) {
            return 'D';
        } else {
            return 'E';
        }
    }
}
