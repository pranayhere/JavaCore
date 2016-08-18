package com.pranay.ThreadPoolExample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i=0; i<1000000; i++) {
			service.submit(new Task(i));
		}
		
	}
}


final class Task implements Runnable {
	private int id;
	public Task(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Task ID : "+this.id+" performed by "+Thread.currentThread().getName());
	}
}
