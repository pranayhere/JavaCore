package com.pranay.BlockingQueueImpl;

/*
 * author : pranay
 */
import java.util.LinkedList;
import java.util.List;

interface BlockingQueueCustom<E> {
	void put(E item) throws InterruptedException;
	E take() throws InterruptedException;
}

class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {
	List<E> queue;
	int maxSize;
	public LinkedBlockingQueueCustom(int maxSize) {
		queue = new LinkedList<E>();
		this.maxSize = maxSize;
	}
	@Override
	public synchronized void put(E item) throws InterruptedException {
		// TODO Auto-generated method stub
		if(queue.size() == maxSize)
			this.wait();
		queue.add(item);
		this.notifyAll();
	}

	@Override
	public synchronized E take() throws InterruptedException {
		// TODO Auto-generated method stub
		if(queue.size()==0)
			this.wait();
		this.notifyAll();
		return this.queue.remove(0);
	}
}

public class BlockingQueueImpl {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueCustom<Integer> q = new LinkedBlockingQueueCustom<Integer>(2);
		q.put(11);
		q.put(12);
		System.out.println(q.take());
		System.out.println(q.take());
	}
}
