package com.pranay.ReenterentLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterentLockDemo {
	public static void main(String[] args) {
		final Counter myCounter = new Counter(new ReentrantLock()); 
		Runnable r = new Runnable() { 
			@Override public void run() { 
				System.out.printf("Count at thread %s is %d %n", Thread.currentThread().getName(), myCounter.getCount()); 
				} 
		};

		for(int i=0; i<100; i++) {
			Thread t = new Thread(r, "T");
			t.start();
		}
	}
}

class Counter { 
	private Lock lock; // Lock to protect our counter 
	private int count; // Integer to hold count 
	public Counter(Lock myLock) 
	{ this.lock = myLock; } 
	public final int getCount() { 
		lock.lock();
		try 
		{ 
			count++; 
			return count;
		} finally { 
			lock.unlock(); 
		} 
	} 
}