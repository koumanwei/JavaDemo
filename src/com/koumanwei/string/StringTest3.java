package com.koumanwei.string;

public class StringTest3 {
    public static void main(String[] args) {
        // 两个字符串中最大相同的子串
        String s1 = "lskdjfabcdefglkjsdf";
        String s2 = "abcd";
        // 既然取的是最大子串
        // 先看短的那个字符串是否在长的那个字符串中
        // 如果不在，那么将短的那个字符串长度=1，然后依次判断
        for (int i = 0; i < s2.length(); i++) {
            for (int a = 0, b = s2.length() - i; b != s2.length() + 1; a++, b++) {
                String sub = s2.substring(a, b);
                if (s1.contains(s2)) {
                    System.out.println(sub);
                    return;
                }
            }
        }
    }
}
