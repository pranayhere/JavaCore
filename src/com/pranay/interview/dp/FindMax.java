package com.pranay.interview.dp;

public class FindMax {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        FindMax fm = new FindMax();
        System.out.println(fm.findMax(nums));
    }
    int[] dp;
    public int findMax(int[] nums) {
        int n = nums.length;
        dp = new int[n];

        if (nums.length <= 1) {
            return 0;
        }
        return Math.max(dfs(nums, 0, n-2), dfs(nums, 1, n - 1));
    }

    public int dfs(int[] nums, int curr, int end) {
        System.out.println(curr + "---" + end);
        if (curr > end)
            return 0;

        if (dp[curr] > 0)
            return dp[curr];

        return dp[curr] = Math.max(dfs(nums, curr + 2,  end) + nums[curr], dfs(nums, curr + 1, end));
    }
}
