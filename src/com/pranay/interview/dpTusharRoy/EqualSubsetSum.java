package com.pranay.interview.dpTusharRoy;

public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean ans = canPartition(nums);
        System.out.println("Ans : " + ans);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n: nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        int total = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][total + 1];

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

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
