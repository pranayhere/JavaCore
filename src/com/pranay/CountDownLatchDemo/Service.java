package com.pranay.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {
	private final String name;
	private final int timeToStart;
	private CountDownLatch latch;
	
	public Service(String name, int timeToStart, CountDownLatch latch) {
		super();
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}
	
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( name + " is Up");
		latch.countDown();
	}
}

