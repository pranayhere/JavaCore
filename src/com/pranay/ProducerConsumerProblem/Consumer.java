package com.pranay.ProducerConsumerProblem;

import java.util.Queue;

class Consumer implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;
	
	public Consumer(Queue<Integer> queue, int maxSize){
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()){
					try {
						System.out.println("Queue is empty");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("consuming value : "+queue.remove());
				queue.notifyAll();
			}
		}
	}	
}
