package com.koumanwei.base;

/**
 * 2017-04-03 19:45
 *
 * @author koumanwei
 * @version 1
 */
public class ArryDemo {
    public static void main(String[] args) {
        // 数组的定义：
        // 同一种类型数据的集合。其实数组就是一个容器
        /**
         * 格式一
         */
        int[] arr1 = new int[8];
        /**
         * 格式二
         */
        int[] arr2 = new int[]{3, 4, 5};
        /**
         * 格式三
         */
        int[] arr3 = {5, 5, 6};
        /**
         * 局部代码块，限定局部变量的生命周期
         */
        {
            int age = 3;
        }
        // 数组创建的时候必须指定其长度
        System.out.println(arr1);
        // 内存的划分
        // 1、寄存器 2、本地方法去 3、方法去 4、栈 5、堆

        /**
         * 栈
         */
        // 存储的都是局部变量，而且变量的作用域一旦结束，该变量就自动释放

        /**
         * 堆
         */
        // 存储的是数组和对象，其实数组就是对象，凡是new建立的都在堆中
        // 堆内存中的变量都有默认初始化值，根据类型的不同而不同
        // 小数 0.0 或者0.0f
        // booelan false
        // char '\u0000'
        int[] arr4 = new int[9];
        // 当访问到的数组不存在的角标时，就会发生该异常ArrayIndexOutOfBoundsException
        // System.out.println(arr4[3]);

        /**
         * 打印结果：[I@4554617c
         */
        // 这是数组实体的哈希值，也就是数组的地址，这是一个16进制值
        // 有“[”代表是这个实体的类型是一个数组，“I”代表是一个int类型，@是分界线
        System.out.println(arr4);
        arr4 = null;
        // 当引用型变量没有任何实体指向时，还在用其操作实体
        // 就会引发NullPointerException
        // System.out.println(arr4[0]);
        // [Ljava.lang.String;@74a14482
        String[] arr5 = new String[]{"nihao", "nihaowo", "women"};
        // 打印角标为偶数的元素，注意这种写法
        for (int i = 0; i < arr5.length; i += 2) {
            System.out.println(arr5[i]);
        }
        System.out.println(arr5);

    }
}
