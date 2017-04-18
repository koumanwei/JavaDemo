package com.koumanwei.generic;

import com.koumanwei.bean.Worker;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 2017-04-18 下午5:29
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericDemo2 {
    public static void main(String[] args) {
        TreeSet<Worker> treeSet = new TreeSet<>(new CompareByName());
        treeSet.add(new Worker("zhansan", 23));
        treeSet.add(new Worker("lisi", 12));
        treeSet.add(new Worker("wangwu", 25));
        treeSet.add(new Worker("zhaoliu", 18));
        Iterator<Worker> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            System.out.println(worker.getName() + " " + worker.getAge());
        }
    }
}
