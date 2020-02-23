package com.pranay.GeeksForGeeks;

// 1353 https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MaximumNumberOfEvents {
	public static void main(String[] args) {
//		int[][] events = {{1,2},{2,3},{3,4}};
//		int[][] events = {{1,2},{2,3},{3,4},{1,2}};
//		int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
//		int[][] events = {{1,100000}};
//		int[][] events = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
//		int[][] events = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
		int[][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};

		int maxEvents = maxEventsPriorityQueue(events);
		System.out.println(maxEvents);
	}

	private static int maxEventsPriorityQueue(int[][] A) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(A, (a,b) -> Integer.compare(a[0], b[0]));

		int i = 0, res = 0, n = A.length;

		for (int d = 1; d <= A[A.length-1][1]; ++d) { // or simply loop to all 10000 days
			while (pq.size() > 0 && pq.peek() < d)
				pq.poll();
			while (i < n && A[i][0] == d)
				pq.offer(A[i++][1]);
			if (pq.size() > 0) {
				pq.poll();
				++res;
			}
		}

		return res;
	}
}
