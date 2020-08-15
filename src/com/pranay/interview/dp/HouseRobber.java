package com.pranay.interview.dp;

import java.util.Arrays;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 *
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 *
 * Step 1. Figure out recursive relation.
 * A robber has 2 options: a) rob current house i; b) don't rob current house.
 * If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
 * If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
 * So it boils down to calculating what is more profitable:
 *
 * robbery of current house + loot from houses before the previous
 * loot from the previous house robbery and any loot captured before that
 * rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        HouseRobber hr = new HouseRobber();
        int money = hr.rob(nums);
        System.out.println("Money : " + money);
    }

    int[] memo;
    private int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0)
            return 0;

        if (memo[i] >= 0)
            return memo[i];

        int result = Math.max(rob(nums,i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}
