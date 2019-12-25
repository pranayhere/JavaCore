package com.pranay.interview.arrays;

import java.util.Arrays;

public class TripletsWithSmallerSum {
	public static void main(String[] args) {
		int[] nums = {5, 1, 3, 4, 7};
		int target = 12;
		int closestSum = threeSumSmaller(nums, target);
		System.out.println(closestSum);
	}

	private static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum < target) {
					count += (k - j);
					j++;
				} else {
					k--;
				}
			}
		}
		return count;
	}
}
