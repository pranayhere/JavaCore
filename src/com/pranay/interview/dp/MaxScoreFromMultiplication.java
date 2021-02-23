package com.pranay.interview.dp;

/**
 * 1770. Maximum Score from Performing Multiplication Operations
 * https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 */

public class MaxScoreFromMultiplication {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] multipliers = {3,2,1};
        int score = maximumScore(nums, multipliers);
        System.out.println("Score : " + score);
    }

    private static int maximumScore(int[] nums, int[] multipliers) {
        return dfs(nums, multipliers, 0, nums.length - 1, 0, 0);
    }

    private static int dfs(int[] nums, int[] multipliers, int i, int j, int idx, int count) {
        int N = nums.length;
        int M = multipliers.length;

        if (idx == M || count >= N)
            return 0;

        int res = Math.max(nums[i] * multipliers[idx] + dfs(nums, multipliers, i + 1, j, idx + 1, count + 1),
                nums[j] * multipliers[idx] + dfs(nums, multipliers, i, j - 1, idx + 1, count + 1));

        return res;
    }
}
