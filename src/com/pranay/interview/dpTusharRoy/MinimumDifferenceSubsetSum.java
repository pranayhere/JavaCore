package com.pranay.interview.dpTusharRoy;

import java.util.Arrays;

/**
 * minimum subset sum difference
 */

public class MinimumDifferenceSubsetSum {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 2, 1};
        int minDiff = minSubsetSumDiff(nums);
        System.out.println("Min Diff : " + minDiff);
    }

    private static int minSubsetSumDiff(int[] nums) {
        int sum = 0;

        for (int n: nums)
            sum += n;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }

        System.out.println(Arrays.deepToString(dp));

        int minDiff = Integer.MAX_VALUE;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[dp.length - 1][i])
                minDiff = Math.min(minDiff, sum - (2 * i));
        }
        return minDiff;
    }
}
