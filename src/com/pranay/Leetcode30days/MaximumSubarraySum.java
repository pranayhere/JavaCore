package com.pranay.Leetcode30days;

public class MaximumSubarraySum {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSum = maxSubArray(nums);
		System.out.println(maxSum);
	}

	private static int maxSubArray(int[] nums) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			currSum = currSum + nums[i];
			maxSum = Math.max(maxSum, currSum);
			currSum = Math.max(currSum, 0);
		}
		return maxSum;
	}
}
