package com.koumanwei.string;

/**
 * Created by koumanwei on 2017-03-19.
 */
public class StringBufferDemo {
    // StringBuffer就是字符串缓冲区
    // 用于存储数据的容器
    // 特点：
    // 1、长度可变
    // 2、可以存储不同类型的数据
    // 3、最终要转成字符串进行使用
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        // 在尾部进行添加
        StringBuffer stringBuffer = sb.append(true).append("nihao").append("shijie");
        // 在指定的位置插入数据
        sb.insert(1, "我们");
        // 删除 包含头，不包含尾
        sb.delete(1, 4);
        // 查找 根据角标查询元素 根据元素查角标
        // 替换
        sb.replace(1, 3, "nbad");
        // 增删改查 CURD Create Update Retrieve Delete
        sb.setLength(30);
        // 清空缓冲区
        // sb.delete(0,sb.length());

        System.out.println(stringBuffer);
    }
}
