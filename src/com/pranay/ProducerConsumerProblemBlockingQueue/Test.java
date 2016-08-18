package com.pranay.ProducerConsumerProblemBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		new Thread(new ProducerBQ(queue)).start();
		new Thread(new ConsumerBQ(queue)).start();
	}
}
