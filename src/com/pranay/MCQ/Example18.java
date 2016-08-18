package com.pranay.MCQ;

class Foo {
	public void count(int i) {
		System.out.println(i);
		count(++i);
	}
}

public class Example18 {
	public static void main(String[] args) {
		Foo a = new Foo();
		a.count(3);
	}
}
