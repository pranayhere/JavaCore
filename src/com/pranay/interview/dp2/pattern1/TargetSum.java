package com.pranay.interview.dp2.pattern1;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        TargetSum ts = new TargetSum();
        int ways = ts.findTargetSumWays(nums, target);
        int ways2 = ts.findTargetSumWaysMemo(nums, target);
        System.out.println("Ways : " + ways);
        System.out.println("Ways Memo : " + ways2);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums, target, nums.length);
    }

    public int targetSum(int[] nums, int target, int n) {
        if (n == 0 && target == 0)
            return 1;

        if (n == 0)
            return 0;

        return targetSum(nums, target + nums[n - 1], n - 1) + targetSum(nums, target - nums[n - 1], n - 1);
    }

    // memo not working
    int[][] dp;
    int sum;
    public int findTargetSumWaysMemo(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        this.sum = sum;

        dp = new int[nums.length + 1][4 * sum];

        return targetSumMemo(nums, target, nums.length);
    }

    public int targetSumMemo(int[] nums, int target, int n) {
        if (n == 0 && target == 0)
            return 1;

        if (n == 0)
            return 0;

        System.out.println(n + " ::: " + target + ":::" + (sum + target));
        if (dp[n][sum + target] > 0)
            return dp[n][sum + target];

        return dp[n][sum + target] = targetSumMemo(nums, target + nums[n - 1], n - 1) + targetSumMemo(nums, target - nums[n - 1], n - 1);
    }
}
