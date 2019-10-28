package com.pranay.interview.dp;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.Arrays;
import java.util.Comparator;

class Job {
	int start;
	int end;
	int profit;

	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Job{" +
				"start=" + start +
				", end=" + end +
				", profit=" + profit +
				'}';
	}
}

class EndTimeComparator implements Comparator<Job> {

	@Override
	public int compare(Job j1, Job j2) {
		return Integer.compare(j1.end, j2.end);
	}
}

public class WeightedJobSchedulingMaximumProfit {
	public static void main(String[] args) {
		int[] startTime = {1,2,3,4,6};
		int[] endTime = {3,5,10,6,9};
		int[] profit = {20,20,100,70,60};

		int maxProfit = jobScheduling(startTime, endTime, profit);
		System.out.println(maxProfit);
	}

	private static int jobScheduling(int[] s, int[] e, int[] p) {
		Job jobs[] = new Job[s.length];
		for (int i=0; i<s.length; i++) {
			jobs[i] = new Job(s[i], e[i], p[i]);
		}
		EndTimeComparator comparator = new EndTimeComparator();
		Arrays.sort(jobs, comparator);
		for (int i = 0; i<jobs.length; i++) {
			System.out.println(jobs[i]);
		}

		return maximum(jobs);
	}

	private static int maximum(Job[] jobs) {
		int[] T = new int[jobs.length];
		for (int i = 0; i<jobs.length; i++) {
			T[i] = jobs[i].profit;
		}
		System.out.println(Arrays.toString(T));

		for (int i = 1; i<jobs.length; i++) {
			for(int j = 0; j<i; j++) {
				if (jobs[j].end <= jobs[i].start) {
					T[i] = Math.max(T[i], T[j] + jobs[i].profit);
				}
			}
		}

		System.out.println(Arrays.toString(T));
		int maxVal = Integer.MIN_VALUE;
		for (int val : T) {
			if (maxVal < val) {
				maxVal = val;
			}
		}
		return maxVal;
	}
}
