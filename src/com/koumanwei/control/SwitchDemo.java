package com.koumanwei.control;

/**
 * 2017-04-01 上午10:08
 *
 * @author koumanwei
 * @version 1
 */
public class SwitchDemo {
    public static void main(String[] args) {
        // switch格式
        // switch(表达式){
        // case 取值1:执行语句；
        // break;
        // case 取值2:执行语句；
        // break;
        // case 取值3:执行语句；
        // break;
        // default:执行语句；
        // break;
        // }
        // 当所有的case都不满足时，才会执行default
        // default后面的break可写可不写
        // 注意：如果default放在前面，也不会先执行，因为default是所有case执行完才执行的
        // 如果case中有一个满足，那么通过该case的break就结束了switch，如果case都不满足，才执行default
        // switch结束只有两种情况，一是执行了break，二执行到了switch语句结束
        int x = 3;
        switch (x) {
            default:
                System.out.println(4);
            case 3:
                System.out.println(3);
                break;
        }
        getMonth();
    }

    public static void getMonth() {
        // 输出季节
        // 3 4 5 春
        // 6 7 8 夏
        // 9 10 11 秋
        // 12 1 2 冬

        int month = 4;
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("月份不存在");
        }
        // 因为只要有一个case满足，那么其他case就不会执行。所以当满足case3时，4，5就不执行
        // 输出春季，当不满足3，满足4时，5也不执行，同样输出春季；其他同理

        // if和switch语句的应用场景
        // 如果是对具体的个数的数值进行判断
        // 用if或者switch都可以，建议使用switch，因为switch会将被选答案进内存，选择效率稍高
        // 如果要对数据区间进行判断，用if
        // 如果运算结果是boolean，毫无疑问，用if
        //
    }
}
