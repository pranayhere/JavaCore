package com.pranay.MCQ;

class A {
	public static void test() {
		System.out.println("inside A test");
	}
}

class B1 extends A {
	public static void test() {
		System.out.println("inside B test");
	}
}
public class INex1 {
	public static void main(String[] args) {
		A a = new B1();
		a.test();
	}
}
