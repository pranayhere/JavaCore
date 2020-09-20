package com.pranay.interview.arrays;

/**
 * 1588. Sum of All Odd Length Subarrays
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        int sum = sumOddLengthSubarrays(arr);
        System.out.println("Sum : " + sum);
    }

    private static int sumOddLengthSubarrays(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];

        int sum = 0;
        for (int i = 1; i <= arr.length; i+=2) {
            sum += arr[i - 1];

            for (int j = i; j < arr.length; j++) {
                sum += arr[j] - arr[j - i];
            }
        }
        return sum;
    }
}
