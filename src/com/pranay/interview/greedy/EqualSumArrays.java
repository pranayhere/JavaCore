package com.pranay.interview.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 1775. Equal Sum Arrays With Minimum Number of Operations
 * https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations
 *
 * In order to make the two sum's equal, we need either to increase to 6 the numbers in the smaller sum array or decrease to 1 the numbers
 * in the bigger sum array;
 * Since we want to complete the task with minimum operations, it is optimal to choose the greater between the increase and decrease.
 * Hence this is a greedy algorithm.
 *
 * Note:
 * If all numbers in an array increasing to 6 still ends up with a sum less than the sum of the other array with all numbers decreasing to 1's, then it is impossible to make their sums equal.
 *
 * Method 1: Sort and 2 pointers
 *
 * 1. Sort both arrays and get their sums respectively: sum1 and sum2;
 * 2. Use two pointers in the two arrays; one pointer from left to right in the array with smaller sum and the other from right to left in the array with bigger sum;
 * 3. In the array with smaller sum, check the difference between current element with 6; in the array with bigger sum, check the difference between
 *    current element with 1; choose the larger difference and add it to sum1.
 * 4. repeat 3 till sum1 >= sum2.
 */
public class EqualSumArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {1,1,2,2,2,2};

        int ops = minOperations(nums1, nums2);
        System.out.println("Min Number of Ops : " + ops);
    }

    private static int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
            return -1;

        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();

        if (sum1 > sum2)
            return minOperations(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = nums2.length - 1;
        int ops = 0;

        while (sum1 < sum2 && j >= 0 && i < nums1.length) {
            if (6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++];
            } else {
                sum2 -= nums2[j--] - 1;
            }
            ops++;
        }

        return ops;
    }
}
