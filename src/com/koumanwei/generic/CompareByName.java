package com.koumanwei.generic;

import com.koumanwei.bean.Worker;

import java.util.Comparator;

/**
 * 2017-04-18 下午6:03
 *
 * @author koumanwei
 * @version 1.0
 */
public class CompareByName implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }
}
