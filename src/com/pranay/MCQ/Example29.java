package com.pranay.MCQ;

public class Example29 {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable obj = new MyRunnable();
		Thread t1 = new Thread(obj,"t1");
		Thread t2 = new Thread(obj,"t2");
		Thread t3 = new Thread(obj,"t3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}
}
