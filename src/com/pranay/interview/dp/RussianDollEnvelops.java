package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/
 */
public class RussianDollEnvelops {
    public static void main(String[] args) {
        int[][] envelops = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int count = maxEnvelopes(envelops);
        System.out.println("Max envelops : " + count);
    }

    private static int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j][0] < nums[i][0] && nums[j][1] < nums[i][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        return max;
    }


}
