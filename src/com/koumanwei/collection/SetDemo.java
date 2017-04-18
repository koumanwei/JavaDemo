package com.koumanwei.collection;

/**
 * 2017-04-17 下午4:37
 *
 * @author koumanwei
 * @version 1.0
 */
public class SetDemo {
    public static void main(String[] args) {
        // Set接口中的方法和Collection一致

        // HashSet：

        // 内部数据结构是哈希表，是不同步的
        // 如何保证该集合元素的唯一性呢？
        // 是通过对象的hashCode和equals方法来完成对象的唯一性的
        // 如果对象的hashCode值不同，那么，不用判断equals方法，就直接存储到哈希表中
        // 如果相同，俺么再次判断对象的equals方法是否为true
        // 如果为true，视为相同元素，不存，如果为false，那么视为不同的元素，就进行存储
        // 记住：如果元素要存储到HashSet中，必须覆盖hashCode和equals方法
        // 一般情况，如果定义的类产生很多对象，比如省，学生，通常都需要覆盖这两个方法，建立
        // 对象判断是否相同的依据

        // TreeSet：

        // 可以对Set集合进行排序，是不同步的
        // 判断元素唯一性的方式，就是根据比较方法的返回结果是否是0，是0就相同，不存
        // TreeSet对元素进行排序的方式一
        // 让元素自身具备比较功能，元素就要实现Comparable接口

        // 如果不要对象中具备的自然排序进行排序，如果对象中不具备自然顺序
        // 可以使用TreeSet集合的第二种排序方式
        // 让集合自身具备比较功能，定义一个类，实现Comparator接口，覆盖compare方法
        // 将该类对象作为参数传递给TreeSet集合的构造函数（常用）
    }
}
