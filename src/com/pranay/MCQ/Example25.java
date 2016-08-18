package com.pranay.MCQ;

class B {
	public synchronized void printName() {
		System.out.println("printName");
	}

	public synchronized void printValue() {
		System.out.println("printValue");
	}
}

public class Example25 implements Runnable {
	B b = new B();
	public static void main(String[] args) {
		Example25 t = new Example25();
		Thread t1 = new Thread(t, "t1");
		Thread t2 = new Thread(t, "t2");
		t1.start();
		t2.start();
	}
	public void run() {
		if(Thread.currentThread().getName().equals("t1")) {
			b.printName();
		} else {
			b.printValue();
		}
	}
}