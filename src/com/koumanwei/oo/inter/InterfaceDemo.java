package com.koumanwei.oo.inter;

/**
 * 2017-04-07 下午3:22
 *
 * @author koumanwei
 * @version 1.0
 */
public class InterfaceDemo {
    public static void main(String[] args) {

    }
}

// 当一个抽象类中全部都是抽象方法的时候，这时，可以将这个抽象类定义成接口
// 接口中常见的成员：
// 1、常量（有固定的修饰符 public static final）
// 接口中不能定义变量
// 2、抽象方法（有固定的修饰符 public abstract）
// 建议写代码的时候，一定要加上这些修饰符

// 接口的特点：
// 1、用interface来定义
// 2、接口中的成员都有固定的修饰符
// 3、不能被实例化
// 4、接口必须由其子类覆盖了所有的抽象方法，否则该子类还是一个抽象类
// 5、接口中的成员都是public修饰的

// 接口的好处：
// 接口可以被多实现
// 这就是多继承机制在java语言被改良后的结果
// 也就是说一个类可以实现多个接口
// 多继承之所以产生调用的不确定性，那是因为方法有主体，但是接口中没有方法体

interface Person {
    public static final int NUM = 3;

    public abstract void show();

    public abstract int show1();
}

class Worker implements Person {


    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public int show1() {
        System.out.println("show1");
        return 0;
    }
}

/**
 * 因为没有实现所有的方法，所以子类也是抽象类
 */
abstract class Teacher implements Person {

    @Override
    public void show() {
        System.out.println("show");
    }
}
