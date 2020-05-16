package com.pranay.Leetcode31DaysOfMay;

public class MaxSubarraySumInCircularArray {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Max Subarray Sum : " + maxSum);
    }

    private static int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        int currSum = nums[0];
        for (int i = 1; i < n * 2; i++) {
            currSum = Math.max(nums[i % n], currSum + nums[i % n]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
