package com.pranay.GeeksForGeeks;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 295. Find Median from Data Stream
 */

public class MedianFromDataStreamTwoHeaps {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public MedianFromDataStreamTwoHeaps() {
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
			return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
		} else if (minHeap.size() > maxHeap.size()) {
			return (double) minHeap.peek();
		} else {
			return (double) maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianFromDataStreamTwoHeaps m = new MedianFromDataStreamTwoHeaps();
		m.addNum(1);
		m.addNum(2);
		m.addNum(3);
		m.addNum(4);
		m.addNum(5);
		double median = m.findMedian();
		System.out.println(median);
	}


}
