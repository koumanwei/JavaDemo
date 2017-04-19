package com.koumanwei.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 2017-04-14 下午2:09
 *
 * @author koumanwei
 * @version 1.0
 */
public class CollDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        show(coll);
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        show(c1, c2);
    }

    public static void show(Collection c1, Collection c2) {
        c1.add("abd1");
        c1.add("abd2");
        c1.add("abd3");
        c1.add("abd4");

        c2.add("abd2");
        c2.add("abd6");
        c2.add("abd7");
        // 将两个集合相同的元素从调用removeAll的集合中删除
        boolean remove = c1.remove(c2);
        // 判断是否包含，c2中的所有元素在c1中都有才是true
        boolean b = c1.containsAll(c2);
        // 取交集，保留和指定的集合相同的元素，而删除不同的元素，和removeAll功能相反
        boolean b1 = c1.retainAll(c2);
//        System.out.println("c1:" + c1);
//        System.out.println("c2:" + c2);
//        c1.add(c2);
        // c1:[abd1, abd2, abd3, abd4, [abd2, abd6, abd7]]
        System.out.println("c1:" + c1);
    }

    public static void show(Collection coll) {
        // 1、添加元素
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        // 集合如果被打印，那么会输出集合中所有的元素
        System.out.println(coll);

        // 2、删除元素
        coll.remove("abc2"); // 会改变集合的长度
        System.out.println(coll);
        coll.clear();
        System.out.println(coll);
    }
}
// 为什么会出现集合类？
// 面向对象的语言对事物的体现都是以对象的形式，所以为了方便对多个对象的操作
// 就对对象进行存储，集合就是存储对象最常用的一种方式
// 数组和集合类都是容器，有何不同？
// 数组也可以存储对象，但是长度是固定的，集合长度是可变的
// 数组中可以存储基本数据类型，集合只能存储对象

// 集合容器因为内部的数据结构不同，有多种容器
// 不断向上抽取，就形成了集合框架
// 框架的顶层，Collection

// Collection的常见方法
// 1、添加
// boolean add(E obj)
// boolean addAll(Collection)

//2、 删除
// boolean remove(E obj)
// boolean removeAll(Collection)
// void clear()

// 3、判断是否存在
// boolean contains(E obj)
// boolean containsAll(Collection)
// isEmtpy()：判断集合中是否有元素

// 4、获取
// int size()
// Iterator iterator()

// 其他
// boolean retainAll() 取交集
// Object[] toArray() 将集合转成数组

// 集合的一些技巧：
// 需要唯一吗？
//     需要：Set
//         需要指定顺序吗？
//             需要：TreeSet
//             不需要：HashSet
//             但是想要一个和存储一致的顺序（有序）：LinkedHashSet
//     不需要：List
//         需要频繁增删吗？
//             需要：LinkedList
//             不需要：ArrayList
// 如何记住每个容器的结构和所属体系呢？
// 看名字！
// 后缀名就是该集合所属的体系
// 前缀名就是该集合的数据结构
// 看到Array就要想到数组，查询块，有角标
// 看到Link就想想到链表，就要想到增删快，就要想到 add get remove + first last的方法
// 看到Hash就要想到哈希表，就要想到唯一性，就要想到需要覆盖hashCode和equals方法
// 看到Tree就要想到二叉树，就要想到排序，就要想到两个接口Comparator和Comparable

// 通常这些容器都是不同步的
