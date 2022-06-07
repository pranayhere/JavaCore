package com.pranay.interview.dp2.pattern1;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,4};
//        int sum = 17;
//        int sum = 0;
//        int sum = 11;
//        int sum = 14;
        int sum = 7;

        boolean ans = subsetSumRec(nums, sum, nums.length);
        System.out.println("Recursive : " + ans);

        boolean ans2 = subsetSumMemo(nums, sum, nums.length);
        System.out.println("Memo : " + ans2);

        boolean ans3 = subsetSumTab(nums, sum, nums.length);
        System.out.println("top down : " + ans3);
    }

    // --------------------------- Recursive ---------------------------
    private static boolean subsetSumRec(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (nums[n - 1] <= sum)
            return subsetSumRec(nums, sum - nums[n - 1], n - 1) || subsetSumRec(nums, sum, n - 1);
        else
            return subsetSumRec(nums, sum, n - 1);
    }


    // ---------------------------- Memo ------------------------------
    static boolean[][] dp = new boolean[6][31];

    private static boolean subsetSumMemo(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (dp[n][sum])
            return true;

        if (nums[n - 1] <= sum)
            return dp[n][sum] = subsetSumMemo(nums, sum - nums[n - 1], n - 1) || subsetSumMemo(nums, sum, n - 1);
        else
            return dp[n][sum] = subsetSumMemo(nums, sum, n - 1);
    }

    // ----------------------------- tabulation  --------------------------
    private static boolean subsetSumTab(int[] nums, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        Arrays.fill(dp[0], false);
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}