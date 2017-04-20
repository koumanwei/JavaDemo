package com.koumanwei.other;

import java.util.Properties;
import java.util.Set;

/**
 * 2017-04-20 下午5:37
 *
 * @author koumanwei
 * @version 1.0
 */
public class SystemDemo {
    public static void main(String[] args) {
        // 获取当前时间的毫秒值
        // 参照1970年1月1日
        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        demo1();
    }

    private static void demo1() {
        // 获取系统的属性信息，并存储到了Properties集合中
        // 存储的都是String类型的键和值
        Properties properties = System.getProperties();
        Set<String> strings = properties.stringPropertyNames();
        for (String name : strings) {
            System.out.println(name + "========" + properties.getProperty(name));
        }
    }
}
