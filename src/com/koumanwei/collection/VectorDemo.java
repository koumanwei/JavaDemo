package com.koumanwei.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * 2017-04-17 下午1:51
 *
 * @author koumanwei
 * @version 1.0
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("abc1");
        vector.add("abc2");
        vector.add("abc3");
        vector.add("abc4");
        // Vector特有的方法
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        // 优先考虑Vector，因为名称较短，而且有删除操作
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
