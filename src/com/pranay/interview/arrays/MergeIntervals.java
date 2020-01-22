package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}

public class MergeIntervals {
	private static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		List<Interval> output = merge(intervals);
		System.out.println(output);
	}

	private static List<Interval> merge(int[][] intervals) {
		List<Interval> intervalList = new ArrayList<>();
		for (int i = 0; i<intervals.length; i++) {
			Interval interval = new Interval(intervals[i][0], intervals[i][1]);
			intervalList.add(interval);
		}

		List<Interval> ans = merge(intervalList);
		return ans;
	}

	private static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());

		System.out.println(intervals);
		LinkedList<Interval> merged = new LinkedList<>();
		for (Interval interval: intervals) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			} else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		return merged;
	}
}
