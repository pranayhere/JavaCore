package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1590. Make Sum Divisible by P
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000};
        int p = 3;

        int len = minSubarray(nums, p);
        System.out.println("Len : " + len);
    }

    private static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int n: nums)
            sum += n;

        if (sum % p == 0)
            return 0;

        long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            ps[i] = ps[i - 1] + nums[i];

        System.out.println(Arrays.toString(ps));

        for (int i = 1; i < ps.length - 1; i++) {
            long currSum = ps[i - 1];
            if ((sum - currSum) % p == 0)
                return i;

            for (int j = i; j < ps.length; j++) {
                currSum = ps[j] - ps[j - i];

                if ((sum - currSum) % p == 0)
                    return i;
            }
        }
        return -1;
    }
}
