package com.pranay.CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CountDownLatch cd = new CountDownLatch(3);
		Thread cacheService = new Thread(new Service("cacheServiceThread", 1000, cd));
		Thread validationService = new Thread(new Service("validationServiceThread", 1000, cd));
		Thread alertService = new Thread(new Service("alertServiceThread", 1000, cd));
		
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
