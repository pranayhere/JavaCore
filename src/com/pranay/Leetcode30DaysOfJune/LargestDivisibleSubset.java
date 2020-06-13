package com.pranay.Leetcode30DaysOfJune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *         0,0,0
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 *         0,0,1,2
 * Output: [1,2,4,8]
 *
 * Sol :
 * Sort the array nums
 * For each element in nums, find the length of largest subset and save in count[]
 * Pick the index of the largest element in count.
 * From nums[maxIndex] to 0, add every element belongs to the largest subset.
 */

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {};
        List<Integer> subset = largestDivisibleSubset(nums);
        System.out.println(subset);
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        for (int i = 1; i<nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        int maxIdx = 0;
        for (int i = 0; i<dp.length; i++) {
            maxIdx = dp[i] > dp[maxIdx] ? i : maxIdx;
        }

        System.out.println(maxIdx);

        int temp = nums[maxIdx];
        int currCount = dp[maxIdx];
        for (int i = maxIdx; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[i] == currCount) {
                result.add(nums[i]);
                temp = nums[i];
                currCount--;
            }
        }
        return result;
    }
}
