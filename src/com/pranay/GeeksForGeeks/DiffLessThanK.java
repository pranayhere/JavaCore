package com.pranay.GeeksForGeeks;

public class DiffLessThanK {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        int len = longestSubarray(nums, limit);
        System.out.println("Len : "+len);
    }

    private static int longestSubarray(int[] nums, int limit) {
        int lo = 0;
        int hi = 0;

        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[hi] - nums[lo]) <= limit) {
                size = Math.min(size, hi - lo);
            }
        }
        return size;
    }
}
