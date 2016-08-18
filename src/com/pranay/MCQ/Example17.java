package com.pranay.MCQ;

import java.util.LinkedList;
import java.util.List;

class Person {
	void say(List<String> list) {
		System.out.println("parent");
	}
}
class Child extends Person {
	void say(List list) {
		System.out.println("child");
	}
}
public class Example17 {
	public static void main(String[] args) {
		Person c = new Child();
		c.say(new LinkedList<String>());
	}
}
