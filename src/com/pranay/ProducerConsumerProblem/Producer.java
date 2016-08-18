package com.pranay.ProducerConsumerProblem;

import java.util.Queue;

class Producer implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;
	
	public Producer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10000;  i++) {
			synchronized (queue) {
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producing value : "+i);
				queue.add(i);
				queue.notifyAll();
			}
		}
	}
}