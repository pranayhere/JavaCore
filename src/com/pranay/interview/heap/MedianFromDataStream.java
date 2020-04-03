package com.pranay.interview.heap;

import java.util.PriorityQueue;

public class MedianFromDataStream {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public MedianFromDataStream() {
		maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
		minHeap = new PriorityQueue<>();
	}

	private void addNum(int num) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(num);
		} else {
			if (num > maxHeap.peek()) {
				minHeap.add(num);
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.add(minHeap.poll());
				}
			} else {
				maxHeap.add(num);
				if (maxHeap.size() > minHeap.size() + 1) {
					minHeap.add(maxHeap.poll());
				}
			}
		}
	}

	private double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (double) minHeap.peek() + maxHeap.peek() / 2;
		} else if (minHeap.size() > maxHeap.size()) {
			return (double) minHeap.peek();
		} else {
			return (double) maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianFromDataStream m = new MedianFromDataStream();
		m.addNum(1);
		m.addNum(2);
		m.addNum(3);
		m.addNum(4);
		m.addNum(5);
		double median = m.findMedian();
		System.out.println(median);
	}


}
