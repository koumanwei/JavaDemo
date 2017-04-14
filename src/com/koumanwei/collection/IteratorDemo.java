package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 2017-04-14 下午3:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");
        coll.add("abc5");
        coll.add("abc6");
        // 调用了Collaction中的iteration方法，为了获取迭代器对象
        Iterator iterator = coll.iterator();
        // 循环完，iterator还能用，也就是说还在内存中
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        // 开发用这种，因为循环结束以后，it就释放了
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
