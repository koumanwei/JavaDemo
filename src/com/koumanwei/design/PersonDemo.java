package com.koumanwei.design;

public class PersonDemo {
	public static void main(String[] args) {
		Person person = new Person();
		NewPerson newPerson = new NewPerson(person);
		newPerson.eat();
	}
}

class Person {
	public void eat() {
		System.out.println("吃饭");
	}
}

// 这个类的出现是为了增强Person而出现的
// 其实用继承覆盖这个eat()方法也能实现这个增强的功能
class NewPerson {
	private Person person;

	public NewPerson(Person person) {
		this.person = person;
	}

	public void eat() {
		System.out.println("开胃酒");
		person.eat();
		System.out.println("甜点");
	}
}
// 装饰和继承都能实现一样的特点：进行功能的扩展增强
// 有什么区别呢？
