package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLongestStrings {
	public static void main(String[] args) {
		int k = 3;
		String[] arr = {"people", "love", "shy", "gamer", "elderly"};
		List<String> list = kLongestStrings(arr, k);
		System.out.println(list);
	}

	private static List<String> kLongestStrings(String[] arr, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.length(), b.length()));
		for (String str: arr) {
			minHeap.add(str);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return new ArrayList<>(minHeap);
	}
}
