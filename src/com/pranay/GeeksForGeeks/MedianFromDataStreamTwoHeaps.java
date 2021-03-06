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
//		if (maxHeap.isEmpty()) {
//			maxHeap.add(num);
//		} else {
//			if (num > maxHeap.peek()) {
//				minHeap.add(num);
//				if (minHeap.size() > maxHeap.size()) {
//					maxHeap.add(minHeap.poll());
//				}
//			} else {
//				maxHeap.add(num);
//				if (maxHeap.size() > minHeap.size() + 1) {
//					minHeap.add(maxHeap.poll());
//				}
//			}
//		}
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());

        System.out.println("Num : " + num);
        System.out.println("MaxHeap : " + maxHeap);
        System.out.println("Minheap : " + minHeap);
        System.out.println("=====================");
	}

	private double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
		}
		return (double) maxHeap.peek();
	}

	public static void main(String[] args) {
		MedianFromDataStreamTwoHeaps m = new MedianFromDataStreamTwoHeaps();
		m.addNum(5);
		System.out.println("5 median : "+m.findMedian());
		m.addNum(4);
		System.out.println("4 median : "+m.findMedian());
		m.addNum(3);
		System.out.println("3 median : "+m.findMedian());
		m.addNum(2);
		System.out.println("2 median : "+m.findMedian());
		m.addNum(1);
		double median = m.findMedian();
		System.out.println(median);
	}


}
