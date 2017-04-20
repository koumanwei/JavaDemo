package com.koumanwei.generic;

import com.koumanwei.bean.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型限定_上限
 * 2017-04-18 23:24
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericAdvanceDemo2 {
    public static void main(String[] args) {
        ArrayList<Worker> a1 = new ArrayList<>();
        a1.add(new Worker("zhandan", 23));
        a1.add(new Worker("lisi", 34));
        a1.add(new Worker("wangwu", 45));

        ArrayList<Student> a2 = new ArrayList<>();
        a1.add(new Worker("小明", 5));
        a1.add(new Worker("小红", 6));
        a1.add(new Worker("闷闷", 7));
        printCollection(a1);
        printCollection(a2);
    }

    /**
     * 打印集合中的元素
     * 这个子类只接收Person的子类
     * 可以对类型进行限定
     * ? extends E：接收E类型或者E的子类。上限
     * ? super E：接收E类型或者E的父类。下限
     *
     * @param arrayList
     */
    private static void printCollection(Collection<? extends Person> arrayList) {
        Iterator<? extends Person> iterator = arrayList.iterator();
        // 因为传进来的都是Person或者Person的子类，所以用父类来接收
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }
    }
    // 泛型的限定，只能接受Person的子类，不像通配符一样，什么类型都可以接收

    /**
     * 泛型的下限
     *
     * @param a1
     */
    private static void printCollentionq(Collection<? super Student> a1) {
        Iterator<? super Student> iterator = a1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
