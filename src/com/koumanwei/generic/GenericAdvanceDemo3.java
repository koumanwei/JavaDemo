package com.koumanwei.generic;

import com.koumanwei.bean.Person;

import java.util.ArrayList;

/**
 * 泛型限定_上限
 * 2017-04-18 23:24
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericAdvanceDemo3 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList1 = new ArrayList<>();
        arrayList1.add(new Student("zhandan", 23));
        arrayList1.add(new Student("lisi", 34));
        arrayList1.add(new Student("wangwu", 45));

        ArrayList<Worker> arrayList2 = new ArrayList<>();
        arrayList2.add(new Worker("zhandan", 23));
        arrayList2.add(new Worker("lisi", 34));
        arrayList2.add(new Worker("wangwu", 45));

        ArrayList<Person> arrayList3 = new ArrayList<>();
        arrayList3.add(new Person("zhandan", 23));
        arrayList3.add(new Person("lisi", 34));
        arrayList3.add(new Person("wangwu", 45));

        arrayList3.addAll(arrayList1);
        arrayList3.addAll(arrayList2);
    }
}
