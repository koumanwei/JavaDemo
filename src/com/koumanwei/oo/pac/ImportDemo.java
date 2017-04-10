package com.koumanwei.oo.pac;

/**
 * 包的导入
 * 2017-04-10 上午9:57
 *
 * @author koumanwei
 * @version 1.0
 */
public class ImportDemo {
    public static void main(String[] args) {

    }
}
// 有了包，类名变得非常长，写起来麻烦
// 解决办法，通过一个关键字来完成
// import的出现，是为了简化类型的书写
// 如果要用到一个包中的多个类，那么可以使用通配符*
// 实际开发中，建议用到哪个类，就导入哪个类，
// 当两个不同的包中出现了同名的类时，一定要用包名进行区分
// 使用时，一定要写全类名 包名.类名
// 注意java中jar.exe的用法，使用来生成jar包的