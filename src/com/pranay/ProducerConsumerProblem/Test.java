package com.pranay.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class Test {
	public static void main(String args[]) {
		Queue<Integer> buffer = new LinkedList<Integer>();
		int maxSize = 5;
		new Thread(new Producer(buffer, maxSize)).start();
		new Thread(new Consumer(buffer, maxSize)).start();
	}
}

