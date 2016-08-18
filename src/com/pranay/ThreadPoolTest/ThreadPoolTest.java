package com.pranay.ThreadPoolTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
	private BlockingQueue<Runnable> taskQueue;
	private List<PoolThreads> threads = new ArrayList<PoolThreads>();
	private boolean isStopped = false;

	public ThreadPool(int nThreads) {
		taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
		for(int i =0; i<nThreads; i++) {
			threads.add(new PoolThreads(taskQueue));
			System.out.println("Thread-"+i +" created in ThreadPool.");
		}
		for(PoolThreads thread : threads) {
			thread.start();
		}
	}

	public synchronized void execute(Runnable task) throws Exception  {
		if(this.isStopped) 
			throw new Exception("ThreadPool is already Stopped, can not add new task");

		System.out.println("task has been added.");
		this.taskQueue.put(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		System.out.println("ThreadPool SHUTDOWN initiated.");
		for(PoolThreads thread : threads) {
			thread.doStop();
		}
	}

}

class PoolThreads extends Thread{
	private BlockingQueue<Runnable> taskQueue;
	private boolean isStopped = false;

	public PoolThreads(BlockingQueue taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while(!this.isStopped) {
			try{
				Runnable runnable = taskQueue.take();
				runnable.run();
			}
			catch(Exception e){
				System.out.println("printing exception");
			}
		}
		System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
	}

	public synchronized void doStop() {
		isStopped = true;
		this.interrupt();
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}

class Task implements Runnable{  
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is executing task.");

	}
};

public class ThreadPoolTest {
	public static void main(String[] args) throws Exception {
		ThreadPool threadPool = new ThreadPool(2);
		Runnable task = new Task();
		threadPool.execute(task);
		threadPool.execute(task);
		
		threadPool.stop();
	}
}
