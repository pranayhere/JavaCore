package com.pranay.interview.arrays;

public class LongestSublistAfterKSets {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        int k = 0;

        LongestSublistAfterKSets ls = new LongestSublistAfterKSets();
        int ans = ls.longestSublist(nums, k);

        System.out.println("Ans : " + ans);
    }

    public int longestSublist(int[] nums, int k) {
        int lo = 0;
        int hi = 0;

        int zeros = 0;
        int len = 0;
        while (hi < nums.length) {
            if (nums[hi] == 0)
                zeros++;

            if (zeros <= k)
                len = Math.max(hi - lo + 1, len);

            while (zeros > k && lo <= hi) {
                if (nums[lo] == 0)
                    zeros--;

                lo++;
            }

            hi++;
        }

        return len;
    }
}
