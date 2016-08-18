package com.pranay.staticMethodsDemo;
/*
 * class a contains static method xyz and so class b. b is subclass of a
 * since static methods can not be overridden but we can redefine them in subclass.
 * Line : a objB = new b();
 * static : super static
 * non static : sub static
 * 
 */
class a {
	static{
		System.out.println("inside static block a");
	}
	public static void xyz(){
		System.out.println("super static");
	} 
}
class b extends a {
	static{
		System.out.println("inside static block b");
	}
	public static void xyz(){
		System.out.println("sub static");
	} 
}
public class staticMethodsDemo {
	static{
		System.out.println("inside static block main");
	}
	public staticMethodsDemo() {
		System.out.println("inside constructor");
	}
	public static void main(String[] args) {
		staticMethodsDemo st = new staticMethodsDemo();
		a objB = new b();
		objB.xyz();
	}
	
	
}