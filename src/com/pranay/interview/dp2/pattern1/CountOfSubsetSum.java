package com.pranay.interview.dp2.pattern1;

import java.util.Arrays;

/**
 * Given an array arr[] of length n and an integer target, the task is to find the number of subsets with a sum equal to target.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 3], target = 6
 * Output: 3
 * Explanation: All the possible subsets are [1, 2, 3], [1, 2, 3] and [3, 3]
 *
 *
 * Input: arr[] = [1, 1, 1, 1], target = 1
 * Output: 4
 * Explanation: All the possible subsets are [1], [1], [1] and [1]
 */
public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10}; // [2,3,5] [2,8] [10]
        int sum = 10;
        int count = countOfSubsetSum(nums, sum, nums.length);
        System.out.println("Count Rec : " + count );

        int countMemo = countOfSubsetMemo(nums, sum, nums.length);
        System.out.println("Count memo : " + countMemo);
//        System.out.println(Arrays.deepToString(dp));

        int countTd = countOfSubsetSumTabulation(nums, sum, nums.length);
        System.out.println("Count top down : " + countTd);
    }


    // -------------------------- Recursive ------------------------------
    private static int countOfSubsetSum(int[] nums, int sum, int n) {
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        if (nums[n - 1] <= sum)
            return countOfSubsetSum(nums, sum - nums[n - 1], n - 1) + countOfSubsetSum(nums, sum, n - 1);
        else
            return countOfSubsetSum(nums, sum, n - 1);
    }

    // -------------------------- Memo ------------------------------------
    static int[][] dp = new int[7][11]; // [nums.length + 1][sum + 1]
    private static int countOfSubsetMemo(int[] nums, int sum, int n) {
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        if (dp[n][sum] > 0)
            return dp[n][sum];

        if (nums[n - 1] <= sum)
            return dp[n][sum] = countOfSubsetMemo(nums, sum - nums[n - 1], n - 1) + countOfSubsetMemo(nums, sum, n - 1);
        else
            return dp[n][sum] = countOfSubsetMemo(nums, sum, n - 1);
    }

    // -------------------------- Tabulation dp -----------------------------
    private static int countOfSubsetSumTabulation(int[] nums, int sum, int n) {
        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
