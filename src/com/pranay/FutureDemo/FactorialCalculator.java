package com.pranay.FutureDemo;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Long> {

	private final int number;
	public FactorialCalculator(int number) {
		this.number = number;
	}
	@Override
	public Long call() throws Exception {
		long output = 0;
		output = factorial(number);
		return output;
	}
	
	private long factorial(int number) throws InterruptedException {
		// TODO Auto-generated method stub
		if(number < 0)
			throw new IllegalArgumentException("number must be greater than zero");
		long result = 1;
		while(number > 0) {
			Thread.sleep(1000);
			result *= number;
			number--;
		}
		return result;
	}
}
