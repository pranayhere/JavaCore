package com.pranay.FutureDemo;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FactorialCalculator task = new FactorialCalculator(18);
		HashMap<String, Integer> map;
		System.out.println("Submitting task...");
		Future future = threadPool.submit(task);
		
		while(!future.isDone()) {
			System.out.println("task is not completed yet...");
			Thread.sleep(100);
		}
		
		System.out.println("Task is completed/..");
		long factorial = (long) future.get();
		System.out.println("factorial of 20 is  : "+factorial);
		
		threadPool.shutdown();
	}

}
