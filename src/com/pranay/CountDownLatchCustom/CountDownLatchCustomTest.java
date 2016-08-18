package com.pranay.CountDownLatchCustom;

class CountDownLatchCustom {
	private int count;
	
	public CountDownLatchCustom(int count) {
		this.count = count;
	}
	
	public synchronized void await() throws InterruptedException {
		if(count > 0)
			wait();
	}
	
	public synchronized void countDown() {
		count--;
		if(count == 0)
			this.notifyAll();
	}
}

public class CountDownLatchCustomTest {
	public static void main(String[] args) {
		final CountDownLatchCustom cd = new CountDownLatchCustom(3);
		Thread cacheService = new Thread(new Service1("cacheServiceThread", 1000, cd));
		Thread validationService = new Thread(new Service1("validationServiceThread", 1000, cd));
		Thread alertService = new Thread(new Service1("alertServiceThread", 1000, cd));
		
		cacheService.start();
		validationService.start();
		alertService.start();
		
		try {
			System.out.println("coming inside");
			cd.await();
			System.out.println("All services are up, application can start now.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
