package com.pranay.interview.arrays;

/**
 * 1524. Number of Sub-arrays With Odd Sum
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
 *
 * Explanation
 * If we know the number of even and odd subarrays that end at the previous element, we can figure out how many even and odd subarrays we have for element n:
 *
 * If n is even, we increase the number of even subarrays; the number of odd subarrays does not change.
 * If n is odd, the number of odd subarrays is the previous number of even subarrays + 1. The number of even subarrays is the previous number of odd subarrays.
 * Looking at this example:
 *
 * Array: [1, 1, 2, 1]  Total
 * Odd:    1  1  1  3     6
 * Even:   0  1  2  1
 */
public class SubarrayWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int count = numOfSubarrays(arr);
        System.out.println("Count : " + count);
    }

    private static int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        int result = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                even++;
            } else {
                int temp = even;
                even = odd;
                odd = temp + 1;
            }
            result = (result + odd) % 1000000007;
        }
        return result;
    }
}
