package com.pranay.Leetcode30days;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {0};
        boolean canJump = canJump(nums);
        System.out.println("can jump ? " + canJump);
    }

    private static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // farthest jump will be less than nums.length
        dp[0] = 0;
        for (int i = 1; i< nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[nums.length - 1] >= 0 && dp[nums.length - 1] < nums.length;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
