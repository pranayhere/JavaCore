package com.pranay.ProducerConsumerProblemBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerBQ implements Runnable {
	BlockingQueue<Integer> queue;
	
	public ConsumerBQ(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Consuming : "+queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
