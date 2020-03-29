package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		int[][] intervals = {{1,3},{6,9}};
		int[] newInterval = {2,5};
		int[][] ansIntervals = insert(intervals, newInterval);
		for (int[] interval : ansIntervals) {
			System.out.println(Arrays.asList(interval));
		}
	}

	private static int[][] insert(int[][] intervals, int[] newInterval) {
		int k = 3;
		System.out.println(k & 1);
		if(intervals.length<=0) {
			int[][] res = new int[1][];
			res[0] = newInterval;
			return res;
		}

		if(newInterval.length<=0) return intervals;

		List<int[]> res = new ArrayList<>();
		for (int[] interval: intervals) {
			if (newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) {
				newInterval[0] = interval[0];
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			} else if (newInterval[1] >= interval[0] && newInterval[1]<= interval[1]) {
				newInterval[1] = interval[1];
				newInterval[0] = Math.min(newInterval[0], interval[0]);
			} else if (newInterval[0] <= interval[0] && newInterval[1] >= interval[1]) {

			} else {
				res.add(interval);
			}
		}
		res.add(newInterval);
		int[][] result = res.toArray(new int[res.size()][]);
		Arrays.sort(result, (i1, i2) -> Integer.compare(i1[0], i2[0]) );
		return result;
	}
}
