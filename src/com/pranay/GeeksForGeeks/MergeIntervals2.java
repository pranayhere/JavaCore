package com.pranay.GeeksForGeeks;

/**
 * https://leetcode.com/problems/merge-intervals/solution/
 * 56. Merge Intervals
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals2 {
	public static void main(String[] args) {
		int[][] intervals = {{2,6}, {1,3}, {8,10}, {15,18}};
		int[][] mergedIntervals = merge(intervals);
		for (int[] mergedInterval: mergedIntervals) {
			System.out.println(Arrays.toString(mergedInterval));
		}
	}

	public static class IntervalComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return Integer.compare(a[0], b[0]);
		}
	}

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		Stack<int[]> stk = new Stack<>();
		List<int[]> res = new ArrayList<>();
 		for (int i=0; i<intervals.length; i++) {
			if (stk.empty() || stk.peek()[1] < intervals[i][0]) {
				stk.push(intervals[i]);
			} else {
				int[] tos = stk.pop();
				tos[1] = Math.max(intervals[i][1], tos[1]);
				stk.push(tos);
			}
		}
 		while (!stk.isEmpty()) {
 			res.add(0, stk.pop());
	    }

 		return res.toArray(new int[res.size()][]);
	}
}
