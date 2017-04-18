package com.koumanwei.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2017-04-18 下午4:59
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericDemo {
    public static void main(String[] args) {
        // jdk1.6之后，后面的String可以不用填写
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("sdg");
        arrayList.add("asd");
        arrayList.add("vfb");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
    // 泛型：jdk1.5出现的新特性
    // 好处：
    // 1、将运行时期的问题ClassCastException转到了编译时期
    // 2、避免了强制转换的麻烦
    // 什么时候用呢？
    // 当操作引用数据类型不确定的时候，就是用泛型，将要操作的引用数据类型传入即可
    // 其实就是一个用于接收具体引用数据类型的参数范围
    // 在程序中，只要用到了带有<>的类或者接口，就要明确具体的引用数据类型
    // 泛型技术是给编译器使用的技术，用于编译时期，确保了类型的安全
    // 运行时会将运行去掉，生成的class文件中是不带泛型的，称为泛型的擦除
    // 为什么擦除呢？
    // 因为为了去兼容运行时的类加载器。
    // 泛型补偿：
    // 在运行时，通过获取元素的类型进行转换动作，不用使用者再强制转换
}
