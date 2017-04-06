package com.koumanwei.oo.inherit;

/**
 * 2017-04-06 下午5:18
 *
 * @author koumanwei
 * @version 1.0
 */
public class ExtendsDemo2 {
    public static void main(String[] args) {
        // 继承中成员的特点：
        // 成员变量 成员函数
        // 构造函数

        // super：代表父类，用法和this相似，this代表本类对象的引用
        // super代表父类所属的空间（不能代表对象）

        // 注意：字父类中通常不会出现同名的属性，因为父类已经有的话，
        // 直接拿来用，没有必要自己再定义该属性

        // 子类只能直接访问父类非私有的成员
        new Zi().show();
    }

}

class Fu {
    // 就算私有了，子类也会继承下来，只不过不能直接访问
    private int num = 3;

    public int getNum() {
        return this.num;
    }
}

class Zi extends Fu {
    int num = 4;

    void show() {
        int num = 5;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(getNum());
        // 为什么子类可以使用父类的内容，因为子类持有父类空间
        // System.out.println(super);
        System.out.println(this);
    }
}
