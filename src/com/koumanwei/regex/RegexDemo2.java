package com.koumanwei.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {

    public static void main(String[] args) {

    }

    // 正则表达式对字符串的常见操作
    // 1、匹配
    // 其实就是String类的match方法
    // 匹配手机号码是否正确
    private static void checkPhoneNumber(String qq) {
        String rel = "15800003333";
        // 第一个为1，第二位3、5、8，后面的9位都是0-9
        String regex = "1[358][0-9]{9}";
        String regex1 = "1[358]\\d{9}";
    }

    // 2、切割，其实就是String类中的splite方法
    private static void functionDemo() {
        String str = "zhangsan   xiaoqiang  wangwu";
        // 一个或者多个空格进行切割
        String regex = " +";
        String str1 = "zhangsan#####xiaoqiang@@@@@zhaoliu";
        // 1表示第一组的内容
        String regtex = "(.)\\1+";
    }

    // 3、替换
    private static void functionDemo2() {
        String str = "zhangsan#####xiaoqiang@@@@@zhaoliu";
        // 把全部叠词变成7
        str = str.replaceAll("(.)\\1+", "8");
        // 158****1111
        String tel = "15800001111";
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    // 4、获取
    // 将正则规则进行对象的封装
    // Pattern p = Pattern.compile("a*b");
    // 通过正则对象的matcher方法与字符串相关联，获取要对字符串操作的匹配器对象Matcher
    //  Matcher m = p.matcher("aaaaab");
    // 通过Matcher匹配器对象的方法对字符串进行操作
    //  boolean b = m.matches();
    private static void functionDemo4() {
        // 获取由三个字母组成的单词
        String str = "da jia hao ming tian bu fang jia";
        // 加上单词的边界
        String regex = "\\b[a-z]{3}\\b";
        // 将正则封装成为对象
        Pattern p = Pattern.compile(regex);
        // 获取匹配其对象
        Matcher m = p.matcher(str);
        // 既然要获取三个字母组成的单词，那么就是查找
        // 获取匹配的子序列
        while (m.find()) {
            String group = m.group();
        }
    }
}
