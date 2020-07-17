package com.pranay.interview.arrays;

public class MinimumSizeSubarray {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {0,2,1,3,4};
        int size = minSubArrayLen(s, nums);
        System.out.println("Size : " + size);
    }

    private static int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while (hi < nums.length) {
            sum += nums[hi++];

            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
