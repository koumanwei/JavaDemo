package com.koumanwei.generic;

import com.koumanwei.bean.Worker;

/**
 * 2017-04-18 20:42
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericDemo3 {
    public static void main(String[] args) {
        Tool<Worker> tool = new Tool<>();
        Worker worker = new Worker("zhansan", 45);
        tool.setT(worker);
        Worker t = tool.getT();
        System.out.println(t.getAge());
        System.out.println(t.getName());
    }
}
