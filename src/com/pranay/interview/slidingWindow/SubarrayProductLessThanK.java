package com.pranay.interview.slidingWindow;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * important to note how we count number of subarrays.... count = count + (right - left + 1)
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int count = numSubarrayProductLessThanK(nums, k);
        System.out.println("Number of subarrays : " + count);
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int prod = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            if (prod >= k)
                prod /= nums[left++];

            count += right - left + 1;
        }

        return count;
    }
}
