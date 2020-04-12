package com.pranay.Leetcode30days;

import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		int stone = lastStoneWeight(stones);
		System.out.println(stone);
	}

	private static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
		for (int i = 0; i < stones.length; i++) {
			maxHeap.add(stones[i]);
		}

		while (maxHeap.size() > 1) {
			int y = maxHeap.poll();
			int x = maxHeap.poll();

			if (x != y) {
				maxHeap.add(y - x);
			}
		}
		return maxHeap.isEmpty() ? 0 : maxHeap.poll();
	}
}
