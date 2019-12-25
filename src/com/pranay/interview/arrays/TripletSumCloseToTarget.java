package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 3Sum Closest
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class TripletSumCloseToTarget {
	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int closestSum = threeSumClosest(nums, target);
		System.out.println(closestSum);
	}

	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int closestSum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(target - sum) < minDiff) {
					minDiff = Math.abs(sum - target);
					closestSum = sum;
				}
				if (sum < target) {
					j++;
				} else if (sum > target) {
					k--;
				} else {
					return target;
				}
			}
		}
		return closestSum;
	}


}
