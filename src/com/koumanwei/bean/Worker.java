package com.koumanwei.bean;

/**
 * 2017-04-18 下午5:44
 *
 * @author koumanwei
 * @version 1.0
 */
public class Worker implements Comparable<Worker> {
    private String name;
    private int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (age != worker.age) return false;
        return name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Worker o) {
        int temp = this.age - o.getAge();
        return temp == 0 ? this.name.compareTo(o.getName()) : temp;
    }
}
