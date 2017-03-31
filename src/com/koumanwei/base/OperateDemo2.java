package com.koumanwei.base;

/**
 * 2017-03-31 下午12:56
 *
 * @author koumanwei
 * @version 1
 */
public class OperateDemo2 {
    public static void main(String[] args) {
        short a = 4;
        // a = a + 4;
        // 将左右两边的和赋给左边
        a += 4;
        // 上面的会编译失败，因为会发生自动类型提升
        // 而下面的不会，是因为+=是赋值运算，会有一个自动转换的动作
        //

        // 逻辑运算符
        // 用来连接boolean类型的表达式
        // & |

        // && 短路与 当左边为false时，右边不参与运算
        // & 两边都运算

        // 位运算符 >> << >>>（无符号右移）
        // 3*2平方=3*2*2;
        System.out.println(3 << 2);
        // 右移是除以2的次幂 原来高位是什么，就用什么补位
        // 左移是乘以2的次幂 空位用零补
        System.out.println(3 >> 8);
        // 把0看成假，1看成真
        System.out.println(6 | 3);
        // 三元运算符
        //（条件表达式）？表达式1：表达式2；
    }
}
