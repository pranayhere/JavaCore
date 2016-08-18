package com.pranay.MCQ;

public class Example24 {
	public static void main(String[] args) {
		Test test = new Test();
		Thread t = new Thread(test);
		t.start();
		t.start();
	}
}

class Test implements Runnable {

	@Override
	public void run() {
		try {
			throw new InterruptedException();
		} catch (Exception e) {
			if(e instanceof ArithmeticException) {
				System.out.println("inside ArithmeticException");
			}
			else if(e instanceof InterruptedException) {
				System.out.println("inside InterruptedException");
			}
		}
		System.out.println("Thread start");
	}	
}

