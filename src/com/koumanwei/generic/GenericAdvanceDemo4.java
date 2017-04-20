package com.koumanwei.generic;

import com.koumanwei.bean.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 泛型限定_下限
 * 2017-04-18 23:24
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericAdvanceDemo4 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet1 = new TreeSet<>(new CompareByPersonName());
        treeSet1.add(new Student("zhandan", 23));
        treeSet1.add(new Student("lisi", 34));
        treeSet1.add(new Student("wangwu", 45));

        TreeSet<Worker> treeSet2 = new TreeSet<>();
        treeSet2.add(new Worker("zhandan", 23));
        treeSet2.add(new Worker("lisi", 34));
        treeSet2.add(new Worker("wangwu", 45));

        TreeSet<Person> treeSet3 = new TreeSet<>(new CompareByPersonName());
        treeSet3.add(new Person("zhandan", 23));
        treeSet3.add(new Person("lisi", 34));
        treeSet3.add(new Person("wangwu", 45));

//        Iterator<Person> iterator = treeSet3.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        Iterator<Student> iterator1 = treeSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        treeSet3.addAll(treeSet1);
        treeSet3.addAll(treeSet2);
    }

    /**
     * 按照Person姓名排序 这里注意：这个只能用父类中的内容进行排序，只能是父类中有的内容进行运算
     * 排序要依次取出集合中的元素，如果用子类中的特有方法来进行排序的运算，就不行
     */
    static class CompareByPersonName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            int temp = o1.getName().compareTo(o2.getName());
            return temp == 0 ? o1.getAge() - o2.getAge() : temp;
        }
    }

    /**
     * 按照Student姓名排序
     */
    static class CompareByStudentName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            int temp = o1.getName().compareTo(o2.getName());
            return temp == 0 ? o1.getAge() - o2.getAge() : temp;
        }
    }

    // 什么时候用下限呢？通常对集合中的元素进行取出操作的时候，可以使用下限
    // 也就是说，你存入任何类型，取出的时候，我都可以用其父类来进行接收

    // 什么时候用上限呢？通常对集合中的元素进行存储操作的时候，可以使用上限
    // 下限用得并不多
}
