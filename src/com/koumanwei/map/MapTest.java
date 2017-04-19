package com.koumanwei.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 2017-04-19 下午12:01
 *
 * @author koumanwei
 * @version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        // 练习："skjhdflksldjkfldkjljunmabvqieyqppgg"
        // 获取该字符串中每个字母出现的次数，要求打印的结果是：a(2)b(1)

        // 分析：
        // 字母和次数之间存在着映射关系，而且这种关系很多。很多就需要存储
        // 能存储映射关系的容器有数组和Map集合
        // 关系一方有序编号吗？没有
        // 所以用Map集合，又发现可以保证唯一性的一方具备着顺序，如a b c
        // 所以就是用TreeMap集合

        // 这个集合中最终存储的是字母和数字的对应关系
        // 因为操作的是字符串中的字母，所以现将字符串变成字符数组
        // 遍历字符数组，用每一个字母作为键取差Map集合这个表
        // 如果字母不存在，就将该字母作为键，1作为值存入这个表
        // 如果该字母存在，就将该字母对应的值取出来，加上1，再存入集合中
        String str = "abccdgffrtyhhjiqukjggskdeamnz";
        char[] chars = str.toCharArray();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!treeMap.containsKey(c)) {
                treeMap.put(c, 1);
            } else {
                treeMap.replace(c, treeMap.get(c) + 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.print(key + "(" + value + ")");
        }
    }
}
