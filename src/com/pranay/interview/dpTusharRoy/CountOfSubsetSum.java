package com.pranay.interview.dpTusharRoy;

import java.util.Arrays;

/**
 * Count of subset sum
 * https://www.youtube.com/watch?v=F7wqWbqYn9g
 */

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10};
        int K = 10;

        int count = countOfSubsetSum(nums, K);
        System.out.println("Count : " + count);
    }

    private static int countOfSubsetSum(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
