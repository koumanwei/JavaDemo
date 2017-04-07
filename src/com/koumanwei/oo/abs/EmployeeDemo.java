package com.koumanwei.oo.abs;

/**
 * 2017-04-07 下午2:35
 *
 * @author koumanwei
 * @version 1.0
 */
public class EmployeeDemo {
    public static void main(String[] args) {
    }
}

// 雇员示例：
// 公司中程序员有姓名，工号，薪水，工作内容。
// 项目经理除了有以上的内容外，还有奖金
// 对给出的需求进行数据建模

// 项目经理和程序员的工作内容不一样，所以应该抽象，由子类具体实现
abstract class EmPloyee {
    // 姓名
    private String name;
    // 工号
    private int jobNumber;
    // 薪水
    private int salary;

    public EmPloyee(String name, int jobNumber, int salary) {
        this.name = name;
        this.jobNumber = jobNumber;
        this.salary = salary;
    }

    // 工作内容
    abstract void work();
}

/**
 * 程序员
 */
class Programmer extends EmPloyee {
    public Programmer(String name, int jobNumber, int salary) {
        super(name, jobNumber, salary);
    }

    @Override
    void work() {
        System.out.println("coding");
    }
}

/**
 * 项目经理
 */
class ProjectManager extends EmPloyee {
    private double bouns;

    public ProjectManager(String name, int jobNumber, int salary, double bouns) {
        super(name, jobNumber, salary);
        this.bouns = bouns;
    }

    @Override
    void work() {
        System.out.println("manager");
    }
}