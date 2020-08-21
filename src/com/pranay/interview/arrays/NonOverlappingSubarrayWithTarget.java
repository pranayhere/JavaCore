package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */
public class NonOverlappingSubarrayWithTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 3, 4, 1, 1, 1};
        int target = 3;

        int len = minSumOfLengths(arr, target);
        System.out.println("Len : " + len);
    }

    private static int minSumOfLengths(int[] arr, int target) {
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];

        int sum = 0;
        int start = 0;
        int leftLen = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                leftLen = Math.min(leftLen, i - start + 1);
            }
            left[i] = leftLen;
        }
        System.out.println(Arrays.toString(left));

        sum = 0;
        start = arr.length - 1;
        int rightLen = Integer.MAX_VALUE;

        for (int i = start; i >= 0; i--) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start];
                start--;
            }

            if (sum == target) {
                rightLen = Math.min(rightLen, start - i + 1);
            }
            right[i] = rightLen;
        }

        System.out.println(Arrays.toString(right));

        long max = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            max = Math.min(left[i - 1] + right[i], max);
        }

        return (int) (max >= Integer.MAX_VALUE ? -1 : max);
    }
}