package com.pranay.deadlockDemo;

public class DeadLockTest {

	// define the locks
	private static Object lockA = new Object();
	private static Object lockB = new Object();

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Creating a deadlock situation :) \n");

		Thread threadA = new Thread(new WorkerA(), "A");
		Thread threadB = new Thread(new WorkerB(), "B");

		threadA.start(); 
		threadB.start();
	}

	static class WorkerA implements Runnable{

		@Override
		public void run() {

			// acquire lock A first
			synchronized (lockA) {

				System.out.println("Worker A acquired lock on lock A");

				// sleep to let other thread acquire lock B 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println("Worker A waiting to acquire lock on lock B. If it can not then it is a deadlock!");

				// now, try acquiring lock B. It can't.
				synchronized (lockB) {
					// won't get here 
					System.out.println("Worker A acquired lock on lock B");


					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} // synchornized block on lock B ends
			} // synchornized block on lock A ends
		} // run() method ends
	} // class WorkerA ends

	static class WorkerB implements Runnable{

		@Override
		public void run() {

			synchronized (lockA) {

				System.out.println("Worker B acquired lock on lock B");

				// sleep to let other thread acquire lock A
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				System.out.println("Worker B waiting to acquire lock on lock A. If it can not then it is a deadlock!");

				// now, try acquiring lock A. It can't.
				synchronized (lockB) {
					// won't get here 
					System.out.println("Worker B acquired lock on lock A");

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

}