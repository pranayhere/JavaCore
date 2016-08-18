package com.pranay.CountDownLatchCustom;


public class Service1 implements Runnable {
	private final String name;
	private final int timeToStart;
	private CountDownLatchCustom latch;
	
	public Service1(String name, int timeToStart, CountDownLatchCustom latch) {
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