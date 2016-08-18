package com.pranay.ProducerConsumerProblemBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ProducerBQ implements Runnable {
	BlockingQueue<Integer> queue;
	
	public ProducerBQ(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		for(int i=0;;i++) {
			try {
				System.out.println("Producing : "+i);
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
