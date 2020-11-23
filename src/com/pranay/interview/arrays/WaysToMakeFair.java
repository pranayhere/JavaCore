package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1664. Ways to Make a Fair Array
 * https://leetcode.com/problems/ways-to-make-a-fair-array/
 *
 * The idea is when we remove an element from index i, the odd sum starting from i + 1 will become the even sum
 * and the even sum starting from i + 1 will become the odd sum. So at any position i, we can maintain the odd sum
 * and even sum at its left and right sides respectively and check if left odd sum plus right even sum equals left even sum plus right odd sum.
 */
public class WaysToMakeFair {
    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 4};
        int count = waysToMakeFair(nums);
        System.out.println("Count : " + count);
    }

    // odd = 5 even = 8

    private static int waysToMakeFair(int[] nums) {
        int rightOddSum = 0, rightEvenSum = 0, leftOddSum = 0, leftEvenSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                rightEvenSum += nums[i];
            else
                rightOddSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                rightEvenSum -= nums[i];
                if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum)
                    res++;
                leftEvenSum += nums[i];
            } else {
                rightOddSum -= nums[i];
                if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum)
                    res++;
                leftOddSum += nums[i];
            }
        }

        return res;
    }
}
