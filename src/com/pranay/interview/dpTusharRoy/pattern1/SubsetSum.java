package com.pranay.interview.dpTusharRoy.pattern1;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int total = 30;
        int[] nums = {2, 3, 7, 8, 10};

        boolean ans = subsetSum(nums, total);
        System.out.println("Ans : " + ans);
    }

    private static boolean subsetSum(int[] nums, int total) {
        boolean[][] dp = new boolean[nums.length + 1][total + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
