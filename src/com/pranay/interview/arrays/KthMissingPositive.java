package com.pranay.interview.arrays;

/**
 * 1539. Kth Missing Positive Number
 * https://leetcode.com/problems/kth-missing-positive-number/solution/
 */
public class KthMissingPositive {
    public static void main(String[] args) {
//        int[] arr = {2,3,4,7,11}; // 1,5,6,8,9,10
//        int k = 5;

        int[] arr = {1,2,3,4};
        int k = 2;

        int num = findKthPositive(arr, k);
        System.out.println("Kth missing positive is : " + num);
    }

    private static int findKthPositive(int[] arr, int k) {
        int prev = 0;
        int missingCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            missingCount += curr - prev - 1;
            prev = curr;

            if (missingCount >= k) {
                return curr - (missingCount - k) - 1;
            }
//            System.out.println("Missing count : " + missingCount);
        }

        int diff = k - missingCount;
        int last = arr[arr.length - 1];
        return last + diff;
    }
}
