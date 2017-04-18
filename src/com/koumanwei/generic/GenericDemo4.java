package com.koumanwei.generic;

/**
 * 2017-04-18 20:42
 *
 * @author koumanwei
 * @version 1.0
 */
public class GenericDemo4 {
    public static void main(String[] args) {
        Tool<String> tool = new Tool<>();
        tool.show("nihao");
        tool.show(8);
        tool.print("dajiahao");
        Tool.methoe("women");
    }
}
