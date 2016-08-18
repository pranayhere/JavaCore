package com.pranay.ThreadExecDemo;

public class ThreadExecDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadDemo(),"t1");
		Thread t2 = new Thread(new ThreadDemo(),"t2");
		Thread t3 = new Thread(new ThreadDemo(),"t3");
		t1.start();
		Thread.sleep(5);
		t2.start();
		Thread.sleep(5);
		t3.start();
	}
}
class ThreadDemo implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running ");
	}
}