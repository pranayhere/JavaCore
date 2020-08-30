package com.pranay.interview.arrays;

/**
 * 1567. Maximum Length of Subarray With Positive Product
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */

public class MaxProdSubarrayLength {
    public static void main(String[] args) {
//        int[] nums = {1,-2,-3,4};
//        int[] nums = {0,1,-2,-3,-4};
//        int[] nums = {-1, 2};
        int[] nums = {70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86};
//        int[] nums = {1000000000,1000000000};
        int len = getMaxLen(nums);
        System.out.println(len);
    }

    private static int getMaxLen(int[] nums) {
        int M = 1000_000_007;
        long prod = (long)1;
        int len = 0;
        int ptr = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            prod *= nums[i];

            if (prod == 0) {
                prod = 1;
                ptr = i + 1;
                continue;
            }

            prod %= M;
            if (prod > 0) {
                len = Math.max(i - ptr + 1, len);
            }
        }

        prod = 1;
        ptr = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            prod *= nums[i];

            if (prod == 0) {
                prod = 1;
                ptr = i - 1;
                continue;
            }

            prod %= M;

            if (prod > 0) {
                len = Math.max(ptr - i + 1, len);
            }
        }
        return len;
    }
}
