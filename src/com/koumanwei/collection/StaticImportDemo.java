package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;

/**
 * 2017-04-20 下午2:42
 *
 * @author koumanwei
 * @version 1.0
 */
public class StaticImportDemo {
    public static void main(String[] args) {
        // 导包的目的是简化书写
        List<String> list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        // import static java.util.Collections.max;
        // 静态导入，其实导入的就是类中的静态成员
        max(list);

//        System.out.println(Collections.max(list));
    }
}
